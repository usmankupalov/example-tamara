package com.example.shopinternet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EngineDto {
    @Min(1)
    private Integer engineId;
    @NotBlank
    private String engineName;
    private BodyDto bodyDto;
}
