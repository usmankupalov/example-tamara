package com.example.shopinternet.controllers.body.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private Integer userId;
    private String phoneNumber;
    private String password;
    List<String> roleList;
}
