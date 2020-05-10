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
    public List<Movie> getMoviesOnMainPage() {
        return sessionFactory.getCurrentSession().createQuery("from Movie m where m.posterOnMainPage!=''").list();
    }


}
