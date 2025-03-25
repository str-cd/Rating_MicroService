package com.UserService.Controller;

import com.UserService.Entity.User;
import com.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User user1 = userService.addUser(user);

        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> li = userService.getAllUsers();

        return new ResponseEntity<>(li,HttpStatus.FOUND);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }
}
