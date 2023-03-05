package com.example.shopinternet.service.model;

import com.example.shopinternet.model.Generation;

import java.util.List;

public interface GenerationService {
    void addGeneration(Generation generation);
    Generation findGenerationByName(String generationName);
    Generation findGenerationByGenerationId(Integer generationId);
    List<Generation> findGenerationsByCarModelName(String carModelName);
    List<Generation> findGenerationsByCarModelId(Integer carModelId);
    void updateGeneration(String generationName, Integer generationId);
    void deleteGeneration(Integer generationId);
}
