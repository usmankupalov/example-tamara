package com.example.shopinternet.service.model;

import com.example.shopinternet.model.Engine;

import java.util.List;

public interface EngineService {
    void addEngine(Engine engine);
    Engine findEngineByEngineName(String engineName);
    Engine findEngineByEngineId(Integer engineId);
    List<Engine> findEnginesByBodyName(String bodyName);
    List<Engine> findEnginesByBodyId(Integer bodyId);
    void updateEngine(String engineName, Integer engineId);
    void deleteEngine(Integer engineId);
}
