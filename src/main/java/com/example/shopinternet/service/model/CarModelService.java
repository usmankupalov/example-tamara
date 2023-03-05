package com.example.shopinternet.service.model;

import com.example.shopinternet.model.CarModel;

import java.util.List;

public interface CarModelService {
    void addCarModel(CarModel carModel);
    CarModel findCarModelByCarModelName(String carModelName);
    CarModel findCarModelByCarModelId(Integer carModelId);
    List<CarModel> findCarsModelByCarName(String carName);
    List<CarModel> findCarModelsByCarId(Integer carId);
    void updateCarModel(String carModelName, Integer carModelId);
    void deleteCarModel(Integer carModelId);
}
