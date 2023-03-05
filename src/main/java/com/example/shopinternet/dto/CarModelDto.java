package com.example.shopinternet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModelDto {
    @Min(1)
    private Integer carModelId;
    @NotBlank
    private String carModelName;
}
