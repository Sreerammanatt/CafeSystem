package com.example.Cafe.Service;


import com.example.Cafe.Domain.User;
import com.example.Cafe.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    @Autowired

    private UserRepo userRepo;

    private PasswordEncoder passwordEncoder;

    public User findUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    public User saveUser(User user) {
     return userRepo.save(user);
    }

    public void saveAllUser(List<User> user) {
        userRepo.saveAll(user);
    }

    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "Product deleted" + id;
    }

    public User updateUser(User user) {
        User userExisting = userRepo.findById(user.getId()).orElse(null);
        if (!(userExisting == null)) {
            userExisting.setName(user.getName());
            userExisting.setPhone(user.getPhone());
            userRepo.save(userExisting);

        }

        return userExisting;


    }

}
