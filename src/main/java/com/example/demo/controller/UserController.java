package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user/{id}")
    private ResponseEntity userById(@PathVariable Long id) {
        Optional<User> user = userService.get(id);
        if(user.isPresent()) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/user/name/{firstName}")
    private ResponseEntity userByName(@PathVariable String firstName) {
        Optional<User> user = userService.get(firstName);
        if(user.isPresent()) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/user")
    private ResponseEntity user(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

}
