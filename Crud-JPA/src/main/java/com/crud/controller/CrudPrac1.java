package com.crud.controller;


import com.crud.model.User;
import com.crud.service.UserServicePrac1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("Prac1")
@RestController
public class CrudPrac1 {

    @Autowired
    UserServicePrac1 userServicePrac1;

    @PostMapping("/save")
    public ResponseEntity<User> user(@RequestBody User user) {
        User user1 = userServicePrac1.addUsers(user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> user() {
        return ResponseEntity.ok(userServicePrac1.getAllusers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> user(@PathVariable int id) {
        return userServicePrac1.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<?> users() {
        int del = userServicePrac1.deleteUsers();
        return ResponseEntity.ok(
                del > 0 ? del + " users deleted successfully." : "No users found to delete."
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> user(@PathVariable int id, @RequestParam String name) {

        int updatedCount = userServicePrac1.patchUpdate(id, name);
        return ResponseEntity.ok(
                updatedCount > 0 ? "User name updated successfully." : "User not found."
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> users(@PathVariable int id, @RequestBody Map<String, String> body) {

        String newName = body.get("name");
        boolean updated = userServicePrac1.updateUserName(id, newName);
        if (updated) {
            return ResponseEntity.ok("User updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }

    }


}
