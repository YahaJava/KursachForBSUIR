package model.director;

import model.movie.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBDirectorDAO implements DirectorDAO {


    @Override
    public Director getDirectorOnId(int id) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Director.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Director director = session.get(Director.class, id);
            session.getTransaction().commit();
            factory.close();
            return director;
    }
}
