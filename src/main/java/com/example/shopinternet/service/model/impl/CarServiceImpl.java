package com.example.shopinternet.service.model.impl;

import com.example.shopinternet.model.Car;
import com.example.shopinternet.repository.model.CarRepository;
import com.example.shopinternet.service.model.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(Car car) {
        car.setCarName(car.getCarName());
        carRepository.save(car);
    }

    @Override
    public Car findCarByCarName(String carName) {
        return carRepository.findCarByCarName(carName);
    }

    @Override
    public Car findCarByCarId(Integer carId) {
        return carRepository.findCarByCarId(carId);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void updateCar(String carName, Integer carId) {
        carRepository.updateCar(carName, carId);
    }

    @Override
    public void deleteCar(Integer carId) {
        carRepository.deleteCarByCarId(carId);
    }
}
