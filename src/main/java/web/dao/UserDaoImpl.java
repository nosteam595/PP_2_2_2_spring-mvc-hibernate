package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        TypedQuery<User> allUsers = sessionFactory.getCurrentSession().createQuery("FROM User");
        return allUsers.getResultList();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);

    }

    @Transactional
    @Override
    public void removeUser(User user) {
        sessionFactory.getCurrentSession().remove(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        User userUpdate = sessionFactory.getCurrentSession().get(User.class, user.getId());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setAge(user.getAge());
    }
}
