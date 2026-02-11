package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.allUsers());
        return "users";
    }

    @GetMapping("/add")
    public String addNewUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "userAdd";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
}
