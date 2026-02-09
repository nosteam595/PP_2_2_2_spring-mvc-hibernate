package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.HibernateConfig;
import web.model.User;
import web.service.UserService;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Петр", "Петров", "petrov@bk.ru", 30);
        User user2 = new User("Василий", "Васин", "vasin@bk.ru", 35);
        User user3 = new User("Егор", "Егоров", "egorov@bk.ru", 40);
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        System.out.println(userService.allUsers());

        userService.removeUser(user1);

        System.out.println(userService.allUsers());

        User user4 = new User("Егор", "Петров", "petrov@bk.ru", 30);
        userService.updateUser(3, user4);

        System.out.println(userService.allUsers());

    }
}
