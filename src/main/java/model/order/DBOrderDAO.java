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
        return sessionFactory.getCurrentSession().createQuery("from Order o where o.movie.id ="+movieId+" and o.date ='"+date+"' and o.time = '" + time+"' and o.status = 'Active'").list();
    }

    @Override
    public void addOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Order> getUserOrders(String username) {
       return sessionFactory.getCurrentSession().createQuery("from Order o where o.user.login ='"+username+"' order by o.date desc , o.time desc ").list();
    }

    @Override
    public void deleteOrder(int id) {
        Order order = sessionFactory.getCurrentSession().get(Order.class, id);
        order.setStatus("Cancel");
        sessionFactory.getCurrentSession().update(order);
    }
}
