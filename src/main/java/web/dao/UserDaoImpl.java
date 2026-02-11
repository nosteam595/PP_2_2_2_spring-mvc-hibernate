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

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        TypedQuery<User> allUsers = sessionFactory.getCurrentSession().createQuery("FROM User");
        return allUsers.getResultList();
    }

    @Override
    public User getUser(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);

    }

    @Override
    public void removeUser(User user) {
        sessionFactory.getCurrentSession().remove(user);
    }

    @Override
    public void updateUser(User userToUpdate) {
        User userForUpdate = sessionFactory.getCurrentSession().get(User.class, userToUpdate.getId());
        userForUpdate.setFirstName(userToUpdate.getFirstName());
        userForUpdate.setLastName(userToUpdate.getLastName());
        userForUpdate.setEmail(userToUpdate.getEmail());
        userForUpdate.setAge(userToUpdate.getAge());
    }

}
