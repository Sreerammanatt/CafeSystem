package com.example.Cafe.Controller;

import com.example.Cafe.Domain.User;
import com.example.Cafe.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/registration")
class UserController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
    return "redirect:/registration?success";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }



//    @PostMapping("/addAllUser")
//    public void addAllUser(@RequestBody List<User> user) {
//        userService.saveAllUser(user);
//
//    }
//
//    @GetMapping("/getUser/{id}")
//    public User getUser(@PathVariable Long id) {
//        return userService.findUser(id);
//
//    }
//
//    @GetMapping("/name")
//    public String getAllUser(Model model) {
//        model.addAttribute("listUser", userService.findAllUser());
//        return "index";
//
//    }
//
//    @PutMapping("/update")
//    public User updateUser(@RequestBody User user) {
//        return userService.updateUser(user);
//
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        return userService.deleteUser(id);
//    }

}



