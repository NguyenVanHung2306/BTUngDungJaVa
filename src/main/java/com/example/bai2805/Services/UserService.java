package com.example.bai2805.Services;


import com.example.bai2805.Entities.User;
import com.example.bai2805.Repositories.UserRepository;
import com.example.bai2805.RequestEntities.RequestCreateUser;
import com.example.bai2805.RequestEntities.RequestUpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    public User createUser(RequestCreateUser requestCreateUser) {
        try {
            User user = new User();
            user.setUsername(requestCreateUser.getUsername());
            user.setEmail(requestCreateUser.getEmail());
            user.setFirstname(requestCreateUser.getFirstname());
            user.setLastName(requestCreateUser.getLastName());
            user.setDeleted(false);
            user.setRole(requestCreateUser.getRole());
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found")
        );
    }

    public User updateUser(String id, RequestUpdateUser requestUpdateUser) {
        try {
            User user = getUserById(id);
            user.setUsername(requestUpdateUser.getUsername());
            user.setEmail(requestUpdateUser.getEmail());
            user.setFirstname(requestUpdateUser.getFirstname());
            user.setLastName(requestUpdateUser.getLastName());
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteUserById(String id) {
        User user = getUserById(id);
        user.setDeleted(true);
        userRepository.save(user);
    }
}