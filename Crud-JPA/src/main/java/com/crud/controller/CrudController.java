package com.crud.controller;


import com.crud.LooseCouple.Mains;
import com.crud.model.User;
import com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudController {

    @Autowired
    private UserService service;

    @Autowired
    private Mains main;

    @PostMapping
    public ResponseEntity<User> users(@RequestBody User user) {
        User user1 = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> users() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    //Optional<User> -> User   map()
    @GetMapping("id")
    public ResponseEntity<User> users(@PathVariable int id) {
        return service.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Integer id,
            @RequestBody User user) {

        Optional<User> existingUser = service.getUserById(id);

        if (existingUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        user.setId(id);

        User updatedUser = service.updateUser(user);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {

        Optional<User> existingUser = service.getUserById(id);

        if (existingUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deleteUser(id);

        return ResponseEntity.ok("User deleted successfully");
    }


}
