package com.springbootprojects.JobPortal.controller;

import com.springbootprojects.JobPortal.model.User;
import com.springbootprojects.JobPortal.service.JwtService;
import com.springbootprojects.JobPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("register")
    public User register(@RequestBody User user){
        return service.addUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){

        Authentication authenticate= authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authenticate.isAuthenticated())
            return jwtService.generateToken(user.getUsername());

        return "Failed to login";
    }


}
