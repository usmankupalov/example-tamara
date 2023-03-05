package com.example.shopinternet.controllers.body.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String password;
}
