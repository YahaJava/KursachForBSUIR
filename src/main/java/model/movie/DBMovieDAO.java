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
        session.beginTransaction();
        List<Movie> movies = session.createQuery("from Movie m where m.inRent=true").list();
        session.getTransaction().commit();
        factory.close();
        return movies;
    }

    @Override
    public Movie getMovieOnId(int id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Movie.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, id);
        session.getTransaction().commit();
        factory.close();
        return movie;
    }



    @Override
    public List<Movie> getMoviesInNoneRent() throws SQLException {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() throws SQLException {
    return  null;
    }

    @Override
    public List<Movie> getMoviesOnActors(Actor actor) throws SQLException {
        return null;
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
        for (String str : list1) {
            stmt.execute("UPDATE Movies SET inRent='1' where name ='" + str + "'");
        }
        for (String str : list2) {
            stmt.execute("UPDATE Movies SET inRent='0' where name ='" + str + "'");
        }
    }


}
