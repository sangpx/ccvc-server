package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.entity.User;

import java.util.Optional;

public interface UserService {
    //Kiem tra UserName da ton tai chua
    boolean existsByUsername(String userName);
    boolean existsByEmail(String email);
    Optional<User> findByUsername(String userName);
    User saveOrUpdate(User user);
}