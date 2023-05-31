package com.example.specification.controller;

import com.example.specification.model.UserProfile;
import com.example.specification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "users")
    public List<UserProfile> getUsersByNames(@RequestParam List<String> names) {
        return userService.getByUsername(names);
    }
}
