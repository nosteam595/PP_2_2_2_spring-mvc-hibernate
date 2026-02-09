package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    List<User> allUsers();
    void addUser(User user);
    void removeUser(User user);
    void updateUser(long id, User userToUpdate);
}
