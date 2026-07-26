package com.crud.service;

import com.crud.model.User;
import com.crud.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User save(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getUserById(int id)
    {
        return repo.findById(id);
    }

    public User updateUser(User user) {
        return repo.save(user);
    }
    public void deleteUser(Integer id) {
        repo.deleteById(id);
    }

}
