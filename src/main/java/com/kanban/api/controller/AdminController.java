package com.kanban.api.controller;

import com.kanban.api.enums.UserRole;
import com.kanban.api.model.User;
import com.kanban.api.repository.UserRepository;
import com.kanban.api.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    public final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return adminService.createUser(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return adminService.getAllUsers();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username){
        return adminService.getUser(username);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/{username}")
    public boolean deleteUser(@PathVariable String username){
        return adminService.deleteUser(username);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/users/{username}/role")
    public User changeRole(@PathVariable String username, @RequestBody UserRole role){
        return adminService.changeRole(username, role);
    }


}
