package com.example.shopinternet.dto;

import com.example.shopinternet.detail.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogDto {
    @Min(1)
    private Integer catalogId;
    @NotBlank
    private String catalogName;
    @Min(1)
    private double price;
    @Min(1)
    private Integer amount;
    @NotBlank
    private String catalogType;
    private Image image;
}
