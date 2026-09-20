package com.crud.controller;


import com.crud.LooseCouple.Mains;
import com.crud.model.User;
import com.crud.repo.UserRepository;
import com.crud.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Myusers")
public class CrudController {

    @Autowired
    private UserService service;

    @Autowired
    private Mains main;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> users(@RequestBody User user) {
        User user1 = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    // --- CUSTOM QUERY STARTS ---
    //Custom Query for select all users
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.fetchAllUsers());
    }

    //Custom Query for select users by id

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserByName(@PathVariable int id) {
        return userRepository.getByIdCustom(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //Custom Delete All users
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllUsers() {
        int deletedCount = userRepository.deleteAllUsers();
        return ResponseEntity.ok(
                deletedCount > 0 ? deletedCount + " users deleted successfully." : "No users found to delete."
        );
    }

    //http://localhost:1111/Myusers/updateName/1
    //{
    //    "name": "NewName"
    // }

    @PatchMapping("/updateName/{id}")
    public ResponseEntity<String> patchUserName(
            @PathVariable int id,
            @RequestBody Map<String, String> updates) {

        String newName = updates.get("name");
        int updatedCount = userRepository.patchUserName(id, newName);

        return ResponseEntity.ok(
                updatedCount > 0 ? "User name updated successfully." : "User not found."
        );
    }

    // --- CUSTOM QUERY ENDS ---

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

    @PutMapping("/users/{id}")
    @Transactional
    public ResponseEntity<User> customQueryUserUpdate(@PathVariable int id, @RequestBody User users) {
        int status = userRepository.updateUserName(id, users.getName());
        if (status > 0) {
            System.out.println("✅ User name updated successfully!");
        } else {
            System.out.println("❌ User not found!");
        }

        return ResponseEntity.ok(users);
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
