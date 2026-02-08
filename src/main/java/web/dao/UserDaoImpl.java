package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    //@Autowired
    //private SessionFactory sessionFactory;

    @Override
    public List<User> allUsers() {
        return List.of();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }
}
