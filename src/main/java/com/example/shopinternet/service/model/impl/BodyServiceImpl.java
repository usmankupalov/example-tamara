package com.example.shopinternet.service.model.impl;

import com.example.shopinternet.model.Body;
import com.example.shopinternet.repository.model.BodyRepository;
import com.example.shopinternet.service.model.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyServiceImpl implements BodyService {

    @Autowired
    private BodyRepository bodyRepository;

    public BodyServiceImpl(BodyRepository bodyRepository) {
        this.bodyRepository = bodyRepository;
    }

    @Override
    public void addBody(Body body) {
        body.setBodyName(body.getBodyName());
        bodyRepository.save(body);
    }

    @Override
    public Body findBodyName(String bodyName) {
        return bodyRepository.findBodyByBodyName(bodyName);
    }

    @Override
    public Body findBodyByBodyId(Integer bodyId) {
        return bodyRepository.findBodyByBodyId(bodyId);
    }

    @Override
    public List<Body> findBodiesByGenerationName(String generationName) {
        return bodyRepository.getBodiesByGenerationGenerationName(generationName);
    }

    @Override
    public List<Body> findBodiesByGenerationId(Integer generationId) {
        return bodyRepository.getBodiesByGenerationGenerationId(generationId);
    }

    @Override
    public void updateBody(String bodyName, Integer bodyId) {
        bodyRepository.updateBody(bodyName, bodyId);
    }

    @Override
    public void deleteBody(Integer bodyId) {
        bodyRepository.deleteBodyByBodyId(bodyId);
    }
}
