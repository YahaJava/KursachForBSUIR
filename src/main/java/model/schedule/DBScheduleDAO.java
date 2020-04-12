package model.schedule;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DBScheduleDAO implements ScheduleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Schedule> getScheduleByMovieID(int id) {
        return sessionFactory.getCurrentSession().createQuery("from Schedule s where s.movie.id="+id).list();
    }
}
