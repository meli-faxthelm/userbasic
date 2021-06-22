package com.meli.hql.hql.controller;

import com.meli.hql.hql.dto.UserDTO;
import com.meli.hql.hql.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userToCreate) {
        userService.createUser(userToCreate);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int userId) {
        return ResponseEntity.status(200).body(userService.getUser(userId));
    }

    @PutMapping("{userId}")
    public ResponseEntity<Void> updateUserPassword(@PathVariable int userId, @RequestBody String newPassword) {
        userService.updateUser(userId, newPassword);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(204).build();
    }

}
