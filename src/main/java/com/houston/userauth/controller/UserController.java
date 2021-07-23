package com.houston.userauth.controller;

import com.houston.userauth.entity.UserEntity;
import com.houston.userauth.model.User;
import com.houston.userauth.model.UserRole;
import com.houston.userauth.repository.UserRepository;

import com.houston.userauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<User> registerApi( @RequestBody User newUser){

        User registeredUser = userService.registerUser(newUser);

        return new ResponseEntity<User>(registeredUser, HttpStatus.ACCEPTED);
    }

    @PostMapping("/create-role")
    public ResponseEntity<UserRole> createRoleHandler(@RequestBody UserRole userRole){
        UserRole createdUserRole = userService.createRole(userRole);

        return new ResponseEntity<UserRole>(createdUserRole, HttpStatus.ACCEPTED);
    }

}
