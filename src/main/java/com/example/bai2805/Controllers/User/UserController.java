package com.example.bai2805.Controllers.User;

import com.example.bai2805.Entities.Role;
import com.example.bai2805.Entities.User;
import com.example.bai2805.RequestEntities.RequestCreateUser;
import com.example.bai2805.RequestEntities.RequestUpdateUser;
import com.example.bai2805.Services.UserService;
import com.example.bai2805.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleServices;

    @GetMapping("")
    public String ShowAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "User/index";
    }
    @GetMapping("/edit/{id}")
    public String ShowUserForm(@PathVariable String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "User/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditUser(RequestUpdateUser requestUpdateUser){
        userService.updateUser(requestUpdateUser.getId(),requestUpdateUser);
        return "redirect:/Users";
    }
    @GetMapping("/new")
    public String createForm(Model model){
        User user = new User();
        List<Role> roles = roleServices.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "User/create";
    }
    @PostMapping("/create")
    public String SaveCreateUser(RequestCreateUser requestCreateStudent){
        userService.createUser(requestCreateStudent);
        return "redirect:/Users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteUserById(id);
        return "redirect:/Users";
    }
}
