package model.order;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DBOrderDAO implements OrderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getOrders(String date, String time, int movieId) {
        return sessionFactory.getCurrentSession().createQuery("from Order o where o.movie.id ="+movieId+" and o.date ='"+date+"' and o.time = '" + time+"'").list();
    }
}
