package com.springbootprojects.JobPortal.service;

import com.springbootprojects.JobPortal.model.JobPost;
import com.springbootprojects.JobPortal.model.User;
import com.springbootprojects.JobPortal.repo.JobRepo;
import com.springbootprojects.JobPortal.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    @Autowired
    private JobRepo jobRepo;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public User addUser(User user) {

//        user.setPassword( new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
