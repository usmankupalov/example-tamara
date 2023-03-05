package com.example.shopinternet.service.model;

import com.example.shopinternet.model.User;

public interface UserService {
    User findUserByUserId(Integer userId);
    void saveUser(User user);
    Boolean existByPhoneNumber(String phoneNumber);
}
