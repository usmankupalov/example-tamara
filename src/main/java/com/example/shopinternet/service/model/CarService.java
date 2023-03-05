package com.example.shopinternet.service.model;

import com.example.shopinternet.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    Car findCarByCarName(String name);
    Car findCarByCarId(Integer carId);
    List<Car> getAllCars();
    void updateCar(String carName, Integer carId);
    void deleteCar(Integer carId);
}