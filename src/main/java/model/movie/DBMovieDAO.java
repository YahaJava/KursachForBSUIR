package model.movie;


import model.actor.Actor;
import model.db.DataBase;
import model.director.Director;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DBMovieDAO implements MovieDAO {
    private Connection connection;

   /* public DBMovieDAO() throws SQLException {
            connection= DataBase.getInstance().getConnection();
    }*/


    @Override
    public List<Movie> getMoviesInRent() throws SQLException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Movie.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            List<Movie> movies  = session.createQuery("from Movie m where m.inRent=true").list();
            session.getTransaction().commit();
            return movies;
        }
        finally {
            factory.close();
        }
    }

    @Override
    public List<Movie> getMoviesInNoneRent() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet bdlist = stmt.executeQuery("Select Movies.name,Directors.name,Directors.surname,Directors.career,Directors.birthDate,Directors.birthplace,Directors.photo,Movies.genre,Movies.country,Movies.year,Movies.budget,Movies.description,Movies.poster,Movies.inRent from Movies INNER JOIN Directors on Movies.director_id=Directors.id WHERE Movies.inRent = 0");
        while (bdlist.next()) {
            Statement stm = connection.createStatement();
            ResultSet bdlist1 = stm.executeQuery("SELECT Actors.name,Actors.surname,Actors.career,Actors.birthDate,Actors.birthplace,Actors.photo from (Actors JOIN Actors_in_movies Aim on Actors.id = Aim.id_actor) JOIN Movies on Aim.id_movie = Movies.id where Movies.name='" + bdlist.getString(1) + "'");
            List<Actor> actorslist = new ArrayList<>();
            while (bdlist1.next()) {
                actorslist.add(new Actor(bdlist1.getString(1), bdlist1.getString(2), bdlist1.getString(3), bdlist1.getString(4), bdlist1.getString(5), bdlist1.getString(6)));
            }
            bdlist1.close();
            stm.close();
            movies.add(new Movie(bdlist.getString(1), new Director(bdlist.getString(2), bdlist.getString(3), bdlist.getString(4), bdlist.getString(5), bdlist.getString(6), bdlist.getString(7)), actorslist, bdlist.getString(8), bdlist.getString(9), bdlist.getInt(10), bdlist.getString(11), bdlist.getString(12), bdlist.getString(13),bdlist.getBoolean(14)));
        }
        return movies;
    }

    @Override
    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet bdlist = stmt.executeQuery("Select Movies.name,Directors.name,Directors.surname,Directors.career,Directors.birthDate,Directors.birthplace,Directors.photo,Movies.genre,Movies.country,Movies.year,Movies.budget,Movies.description,Movies.poster,Movies.inRent from Movies INNER JOIN Directors on Movies.director_id=Directors.id");
        while (bdlist.next()) {
            Statement stm = connection.createStatement();
            ResultSet bdlist1 = stm.executeQuery("SELECT Actors.name,Actors.surname,Actors.career,Actors.birthDate,Actors.birthplace,Actors.photo from (Actors JOIN Actors_in_movies Aim on Actors.id = Aim.id_actor) JOIN Movies on Aim.id_movie = Movies.id where Movies.name='" + bdlist.getString(1) + "'");
            List<Actor> actorslist = new ArrayList<>();
            while (bdlist1.next()) {
                actorslist.add(new Actor(bdlist1.getString(1), bdlist1.getString(2), bdlist1.getString(3), bdlist1.getString(4), bdlist1.getString(5), bdlist1.getString(6)));
            }
            bdlist1.close();
            stm.close();
            movies.add(new Movie(bdlist.getString(1), new Director(bdlist.getString(2), bdlist.getString(3), bdlist.getString(4), bdlist.getString(5), bdlist.getString(6), bdlist.getString(7)), actorslist, bdlist.getString(8), bdlist.getString(9), bdlist.getInt(10), bdlist.getString(11), bdlist.getString(12), bdlist.getString(13),bdlist.getBoolean(14)));
        }
        return movies;
    }

    @Override
    public List<Movie> getMoviesOnActors(Actor actor) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet bdlist = stmt.executeQuery("Select Movies.name,Directors.name,Directors.surname,Directors.career,Directors.birthDate,Directors.birthplace,Directors.photo,Movies.genre,Movies.country,Movies.year,Movies.budget,Movies.description,Movies.poster,Movies.inRent from Movies INNER JOIN Directors on Movies.director_id=Directors.id");
        while (bdlist.next()) {
            Statement stm = connection.createStatement();
            ResultSet bdlist1 = stm.executeQuery("SELECT Actors.name,Actors.surname,Actors.career,Actors.birthDate,Actors.birthplace,Actors.photo from (Actors JOIN Actors_in_movies Aim on Actors.id = Aim.id_actor) JOIN Movies on Aim.id_movie = Movies.id where Movies.name='" + bdlist.getString(1) + "' and Actors.name='" + actor.getName() + "' and Actors.surname='" + actor.getSurname() + "'");
            List<Actor> actorslist = new ArrayList<>();
            while (bdlist1.next()) {
                actorslist.add(new Actor(bdlist1.getString(1), bdlist1.getString(2), bdlist1.getString(3), bdlist1.getString(4), bdlist1.getString(5), bdlist1.getString(6)));
            }
            bdlist1.close();
            stm.close();
            if (actorslist.size() != 0)
                movies.add(new Movie(bdlist.getString(1), new Director(bdlist.getString(2), bdlist.getString(3), bdlist.getString(4), bdlist.getString(5), bdlist.getString(6), bdlist.getString(7)), actorslist, bdlist.getString(8), bdlist.getString(9), bdlist.getInt(10), bdlist.getString(11), bdlist.getString(12), bdlist.getString(13),bdlist.getBoolean(14)));
        }
        return movies;
    }

    @Override
    public List<Movie> searchMovies(String searchParameter) throws SQLException {
        List<Movie> movies = getAllMovies();
        searchParameter = searchParameter.toLowerCase();
        String finalSearchParameter = searchParameter;
        movies = movies.stream()
                .filter(movie -> movie.getName().toLowerCase().contains(finalSearchParameter))
                .collect(Collectors.toList());
        return movies;
    }

    @Override
    public void updateRent(ArrayList<String> list1, ArrayList<String> list2) throws SQLException {
        Statement stmt = connection.createStatement();
        for (String str:list1) {
            stmt.execute("UPDATE Movies SET inRent='1' where name ='"+str+"'");
        }
        for (String str:list2) {
            stmt.execute("UPDATE Movies SET inRent='0' where name ='"+str+"'");
        }
    }


}
