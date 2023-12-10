package com.bezkoder.springjwt.serviceImpl;

import com.bezkoder.springjwt.models.entity.User;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //Đánh dấu một Class là tầng Service, phục vụ các logic nghiệp vụ.
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean existsByUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Optional<User> findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }
}
