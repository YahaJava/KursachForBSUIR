package model.actor;

import model.director.Director;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBActorDAO implements ActorDAO {
    @Override
    public Actor getActorOnId(int id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Director.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Actor actor = session.get(Actor.class, id);
        session.getTransaction().commit();
        factory.close();
        return actor;
    }
}
