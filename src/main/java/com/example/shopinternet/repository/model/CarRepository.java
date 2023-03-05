package com.example.shopinternet.repository.model;

import com.example.shopinternet.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    Car findCarByCarName(String carName);
    Car findCarByCarId(Integer carId);
    @Modifying
    @Transactional
    @Query("update Car set carName=:carName where carId=:carId")
    void updateCar(@Param("carName") String carName, @Param("carId") Integer carId);
    @Modifying
    @Transactional
    void deleteCarByCarId(Integer carId);
}
