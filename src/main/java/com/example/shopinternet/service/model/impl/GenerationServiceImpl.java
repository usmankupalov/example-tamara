package com.example.shopinternet.service.model.impl;

import com.example.shopinternet.model.Generation;
import com.example.shopinternet.repository.model.GenerationRepository;
import com.example.shopinternet.service.model.GenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerationServiceImpl implements GenerationService {

    @Autowired
    private GenerationRepository generationRepository;

    public GenerationServiceImpl(GenerationRepository generationRepository) {
        this.generationRepository = generationRepository;
    }

    @Override
    public void addGeneration(Generation generation) {
        generation.setGenerationName(generation.getGenerationName());
        generationRepository.save(generation);
    }

    @Override
    public Generation findGenerationByName(String generationName) {
        return generationRepository.findGenerationByGenerationName(generationName);
    }

    @Override
    public Generation findGenerationByGenerationId(Integer generationId) {
        return generationRepository.findGenerationByGenerationId(generationId);
    }

    @Override
    public List<Generation> findGenerationsByCarModelName(String carModelName) {
        return generationRepository.getGenerationsByCarModelCarModelName(carModelName);
    }

    @Override
    public List<Generation> findGenerationsByCarModelId(Integer carModelId) {
        return generationRepository.getGenerationsByCarModelCarModelId(carModelId);
    }

    @Override
    public void updateGeneration(String generationName, Integer generationId) {
        generationRepository.updateGeneration(generationName, generationId);
    }

    @Override
    public void deleteGeneration(Integer generationId) {
        generationRepository.deleteGenerationByGenerationId(generationId);
    }
}
