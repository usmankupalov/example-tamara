package com.example.shopinternet.service.model.impl;

import com.example.shopinternet.security.UserDetailsImpl;
import com.example.shopinternet.model.User;
import com.example.shopinternet.repository.model.UserRepository;
import com.example.shopinternet.service.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByUserId(Integer userId) {
        return userRepository.findUserByUserId(userId);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean existByPhoneNumber(String phoneNumber) {
        return userRepository.existsUserByPhoneNumber(phoneNumber);
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user = userRepository.findUserByPhoneNumber(phoneNumber);
        if (user != null) {
            return UserDetailsImpl.fromUserEntityToCustomUserDetails(user);
        }

        throw new UsernameNotFoundException("User not found");
    }
}
