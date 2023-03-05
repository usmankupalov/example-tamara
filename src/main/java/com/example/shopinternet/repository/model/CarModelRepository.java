package com.example.shopinternet.repository.model;

import com.example.shopinternet.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Integer> {
    CarModel findCarModelByCarModelName(String name);
    CarModel findCarModelByCarModelId(Integer carModelId);
    List<CarModel> getCarModelsByCarCarName(String carName);
    List<CarModel> getCarModelsByCarCarId(Integer carId);
    @Modifying
    @Transactional
    @Query("update CarModel set carModelName=:carModelName where carModelId=:carModelId")
    void updateCarModel(@Param("carModelName") String carModelName, @Param("carModelId") Integer carModelId);
    @Modifying
    @Transactional
    void deleteCarModelByCarModelId(Integer carModelId);
}
