package model.movie;


import model.actor.Actor;
import model.director.Director;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class DBMovieDAO implements MovieDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Movie> getMoviesInRent() {
        return sessionFactory.getCurrentSession().createQuery("from Movie m where m.inRent=true").list();
    }

    @Override
    public Movie getMovieOnId(int id) {
        return sessionFactory.getCurrentSession().get(Movie.class,id);
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

    }


}
