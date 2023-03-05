package com.example.shopinternet.service.model.impl;

import com.example.shopinternet.model.Engine;
import com.example.shopinternet.repository.model.EngineRepository;
import com.example.shopinternet.service.model.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    private EngineRepository engineRepository;

    public EngineServiceImpl(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public void addEngine(Engine engine) {
        engine.setEngineName(engine.getEngineName());
        engineRepository.save(engine);
    }

    @Override
    public Engine findEngineByEngineName(String engineName) {
        return engineRepository.findEngineByEngineName(engineName);
    }

    @Override
    public Engine findEngineByEngineId(Integer engineId) {
        return engineRepository.findEngineByEngineId(engineId);
    }

    @Override
    public List<Engine> findEnginesByBodyName(String bodyName) {
        return engineRepository.getEnginesByBodyBodyName(bodyName);
    }

    @Override
    public List<Engine> findEnginesByBodyId(Integer bodyId) {
        return engineRepository.getEnginesByBodyBodyId(bodyId);
    }

    @Override
    public void updateEngine(String engineName, Integer engineId) {
        engineRepository.updateEngine(engineName, engineId);
    }

    @Override
    public void deleteEngine(Integer engineId) {
        engineRepository.deleteEngineByEngineId(engineId);
    }
}
