package com.example.shopinternet.dto;

import com.example.shopinternet.detail.Image;
import com.example.shopinternet.model.Engine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailDto {
    @Min(1)
    private Integer detailId;
    @NotBlank
    private String detailName;
    @Min(1)
    private double price;
    @Min(1)
    private Integer amount;
    @NotBlank
    private String catalogType;
    @NotBlank
    private String vinNumber;
    private Image image;
    private Engine engine;
}
