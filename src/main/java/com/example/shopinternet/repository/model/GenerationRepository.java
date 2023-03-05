package com.example.shopinternet.repository.model;

import com.example.shopinternet.model.Generation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, Integer> {
    Generation findGenerationByGenerationName(String generationName);
    Generation findGenerationByGenerationId(Integer generationId);
    List<Generation> getGenerationsByCarModelCarModelName(String carModelName);
    List<Generation> getGenerationsByCarModelCarModelId(Integer carModelId);
    @Modifying
    @Transactional
    @Query("update Generation set generationName=:generationName where generationId=:generationId")
    void updateGeneration(@Param("generationName") String generationName, @Param("generationId") Integer generationId);
    @Modifying
    @Transactional
    void deleteGenerationByGenerationId(Integer generationId);
}
