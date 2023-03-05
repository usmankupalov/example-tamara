package com.example.shopinternet.repository.model;

import com.example.shopinternet.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Integer> {
    Engine findEngineByEngineName(String name);
    Engine findEngineByEngineId(Integer engineId);
    List<Engine> getEnginesByBodyBodyName(String bodyName);
    List<Engine> getEnginesByBodyBodyId(Integer bodyId);
    @Modifying
    @Transactional
    @Query("update Engine set engineName=:engineName where engineId=:engineId")
    void updateEngine(@Param("engineName") String engineName, @Param("engineId") Integer engineId);
    @Modifying
    @Transactional
    void deleteEngineByEngineId(Integer engineId);
}
