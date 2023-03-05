package com.example.shopinternet.repository.model;

import com.example.shopinternet.model.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BodyRepository extends JpaRepository<Body, Integer> {
    Body findBodyByBodyName(String name);
    Body findBodyByBodyId(Integer bodyId);
    List<Body> getBodiesByGenerationGenerationName(String generationName);
    List<Body> getBodiesByGenerationGenerationId(Integer generationId);
    @Modifying
    @Transactional
    @Query("update Body set bodyName=:bodyName where bodyId=:bodyId")
    void updateBody(@Param("bodyName") String bodyName, @Param("bodyId") Integer bodyId);
    @Modifying
    @Transactional
    void deleteBodyByBodyId(Integer bodyId);
}
