package com.realestate.crm.controller;

import com.realestate.crm.entity.User;
import com.realestate.crm.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping("/admin")
public class AdminController {
    private final UserRepository users;
    public AdminController(UserRepository users){this.users=users;}
    @GetMapping("/users") public String users(Model model){model.addAttribute("pageTitle","Users & Roles");model.addAttribute("activePage","users");model.addAttribute("rows",users.findAll());return "users";}
    @PostMapping("/users/save") public String save(@ModelAttribute User user){users.save(user);return "redirect:/admin/users?success=User+saved";}
    @PostMapping("/users/toggle/{id}") public String toggle(@PathVariable Long id){users.findById(id).ifPresent(u->{u.setEnabled(!u.isEnabled());users.save(u);});return "redirect:/admin/users";}
}
