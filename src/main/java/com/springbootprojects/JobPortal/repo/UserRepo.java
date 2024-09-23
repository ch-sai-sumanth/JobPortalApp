package com.springbootprojects.JobPortal.repo;

import com.springbootprojects.JobPortal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {


    User findByUsername(String username);
}
