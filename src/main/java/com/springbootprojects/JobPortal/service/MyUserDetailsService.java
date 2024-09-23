package com.springbootprojects.JobPortal.service;

import com.springbootprojects.JobPortal.model.User;
import com.springbootprojects.JobPortal.model.UserPrinciple;
import com.springbootprojects.JobPortal.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repo.findByUsername(username);

        if(user==null)
            throw new UsernameNotFoundException("User Not Found 404");

        return new UserPrinciple(user);
    }
}
