package com.example.shopinternet.controllers.body.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddModel {
    @NotBlank
    private String carName;
    @NotBlank
    private String carModelName;
    @NotBlank
    private String generationName;
    @NotBlank
    private String bodyName;
    @NotBlank
    private String engineName;
}
