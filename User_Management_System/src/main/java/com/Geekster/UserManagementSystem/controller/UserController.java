package com.Geekster.UserManagementSystem.controller;

import com.Geekster.UserManagementSystem.service.UserService;
import com.Geekster.UserManagementSystem.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String postUser(@Valid @RequestBody User user){
      return userService.addUser(user);
    }

    @GetMapping("/getUser/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.userGetById(userId);
    }

    @GetMapping("/getAllUser")
    public List<User> getUser(){
        return userService.getAllUser();
    }

    @PutMapping(value = "/updateUserInfo/{userId}/{name}")
    public String updateUser(@PathVariable String userId,@PathVariable String name){
        return userService.updateUserById(userId,name)? "Updated successfully":"Not found user with this id..!!";
    }
    @DeleteMapping(value = "/deleteUser/{userId}")
    public String deleteUserByUserId(@PathVariable String userId){
        return userService.removeUserByUserId(userId);
    }

}
