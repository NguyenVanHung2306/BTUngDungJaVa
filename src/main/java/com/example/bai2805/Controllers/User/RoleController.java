package com.example.bai2805.Controllers.User;

import com.example.bai2805.Entities.Role;
import com.example.bai2805.RequestEntities.RequestCreateRole;
import com.example.bai2805.RequestEntities.RequestUpdateRole;
import com.example.bai2805.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Roles")
public class RoleController {
    @Autowired
    private RoleService roleServices;

    @GetMapping("")
    public String ShowAllRoles(Model model){
        List<Role> roles = roleServices.getAllRoles();
        model.addAttribute("roles", roles);
        return "Role/index";
    }
    @GetMapping("/edit/{id}")
    public String ShowRolerForm(@PathVariable String id, Model model){
        Role role = roleServices.getRoleById(id);
        model.addAttribute("role", role);
        return "Role/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditRole(RequestUpdateRole requestUpdateRole){
        roleServices.updateRole(requestUpdateRole.getRole_id(),requestUpdateRole);
        return "redirect:/Roles";
    }
    @GetMapping("/new")
    public String createForm(Model model){
        Role role = new Role();
        model.addAttribute("role", role);
        return "Role/create";
    }
    @PostMapping("/create")
    public String SaveCreateUser(RequestCreateRole requestCreateRole){
        roleServices.createRole(requestCreateRole);
        return "redirect:/Roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        roleServices.deleteRoleById(id);
        return "redirect:/Roles";
    }
}
