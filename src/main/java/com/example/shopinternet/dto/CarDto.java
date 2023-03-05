package com.example.shopinternet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    @Min(1)
    private Integer carId;
    @NotBlank
    private String carName;
}
