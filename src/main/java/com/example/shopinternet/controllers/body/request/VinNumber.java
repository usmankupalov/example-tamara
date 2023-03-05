package com.example.shopinternet.controllers.body.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VinNumber {
    @NotBlank
    private String vinNumber;
}
