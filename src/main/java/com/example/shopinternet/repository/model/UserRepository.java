package com.example.shopinternet.repository.model;

import com.example.shopinternet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByPhoneNumber(String phoneNumber);
    User findUserByUserId(Integer userId);
    Boolean existsUserByPhoneNumber(String phoneNumber);
    Boolean existsUsersByPassword(String password);
}
