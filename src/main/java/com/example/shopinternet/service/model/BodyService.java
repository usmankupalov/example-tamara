package com.example.shopinternet.service.model;

import com.example.shopinternet.model.Body;

import java.util.List;

public interface BodyService {
    void addBody(Body body);
    Body findBodyName(String name);
    Body findBodyByBodyId(Integer bodyId);
    List<Body> findBodiesByGenerationName(String generationName);
    List<Body> findBodiesByGenerationId(Integer generationId);
    void updateBody(String bodyName, Integer bodyId);
    void deleteBody(Integer bodyId);
}
