package com.crud.service;

import com.crud.model.User;
import com.crud.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicePrac1 {

    @Autowired
    UserRepository userRepository;

    public User addUsers(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllusers() {
        return userRepository.fetchAllUsers();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.getByIdCustom(id);
    }

    public int deleteUsers() {
        return userRepository.deleteAllUsers();
    }

    public int patchUpdate(int id , String name)
    {
         return  userRepository.patchUserName(id,name);
    }

    public boolean updateUserName(int id, String name) {
        int rows = userRepository.updateUserNameById(id, name);
        return rows > 0;
    }


}
