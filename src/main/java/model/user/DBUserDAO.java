package model.user;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DBUserDAO implements  UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String login) {
        return sessionFactory.getCurrentSession().get(User.class, login);
    }

    @Override
    public void addUser(User user)
    {
        String encoded=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encoded);
        sessionFactory.getCurrentSession().save(user);
    }

}
