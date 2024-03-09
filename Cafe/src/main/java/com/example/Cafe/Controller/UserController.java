package com.example.Cafe.Controller;

import com.example.Cafe.Domain.User;
import com.example.Cafe.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
class UserController {
    @Autowired
    private UserService userService;

    @PostMapping( "/addUser")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/addAllUser")
    public void addAllUser(@RequestBody List<User> user) {
         userService.saveAllUser(user);

    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findUser(id);

    }

    @GetMapping("/")
    public String getAllUser(Model model) {
        model.addAttribute("listUser",userService.findAllUser());
        model.addAttribute("user",userService.findAllUser().get(0));
        return "index";

    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);

    }
     @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable  Long id) {
        return userService.deleteUser(id);
    }

}



