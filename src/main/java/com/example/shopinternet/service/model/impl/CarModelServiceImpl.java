package com.example.shopinternet.service.model.impl;

import com.example.shopinternet.model.CarModel;
import com.example.shopinternet.repository.model.CarModelRepository;
import com.example.shopinternet.service.model.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    public CarModelServiceImpl(CarModelRepository carModelRepository) {
        this.carModelRepository = carModelRepository;
    }

    @Override
    public void addCarModel(CarModel carModel) {
        carModel.setCarModelName(carModel.getCarModelName());
        carModelRepository.save(carModel);
    }

    @Override
    public CarModel findCarModelByCarModelName(String carModelName) {
        return carModelRepository.findCarModelByCarModelName(carModelName);
    }

    @Override
    public CarModel findCarModelByCarModelId(Integer carModelId) {
        return carModelRepository.findCarModelByCarModelId(carModelId);
    }

    @Override
    public List<CarModel> findCarsModelByCarName(String carName) {
        return carModelRepository.getCarModelsByCarCarName(carName);
    }

    @Override
    public List<CarModel> findCarModelsByCarId(Integer carId) {
        return carModelRepository.getCarModelsByCarCarId(carId);
    }

    @Override
    public void updateCarModel(String carModelName, Integer carModelId) {
        carModelRepository.updateCarModel(carModelName, carModelId);
    }

    @Override
    public void deleteCarModel(Integer carModelId) {
        carModelRepository.deleteCarModelByCarModelId(carModelId);
    }
}
