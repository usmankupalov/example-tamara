package com.example.shopinternet.controllers.admin;

import com.example.shopinternet.controllers.body.resp.Response;
import com.example.shopinternet.detail.Detail;
import com.example.shopinternet.model.*;
import com.example.shopinternet.service.detail.DetailService;
import com.example.shopinternet.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/v1.0")
@Validated
public class AdminPanelDeleteDetails {

    @Autowired
    private CarService carService;

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private GenerationService generationService;

    @Autowired
    private BodyService bodyService;

    @Autowired
    private EngineService engineService;

    @Autowired
    private DetailService detailService;

    @DeleteMapping("/cars/{carsId}")
    public ResponseEntity<?> deleteCar(@PathVariable(value = "carsId") @Min(1) Integer carId) {
        Car car = carService.findCarByCarId(carId);
        if (car != null) {
            carService.deleteCar(car.getCarId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new Response("Not found car"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/carModels/{carModelsId}")
    public ResponseEntity<?> deleteCarModel(@PathVariable(value = "carModelsId") @Min(1) Integer carModelsId) {
        CarModel carModel = carModelService.findCarModelByCarModelId(carModelsId);
        if (carModel != null) {
            carModelService.deleteCarModel(carModel.getCarModelId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new Response("Not found car model"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/generations/{generationsId}")
    public ResponseEntity<?> deleteGeneration(@PathVariable(value = "generationsId") @Min(1) Integer generationsId) {
        Generation generation = generationService.findGenerationByGenerationId(generationsId);
        if (generation != null) {
            generationService.deleteGeneration(generation.getGenerationId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new Response("Not found generation"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/bodies/{bodiesId}")
    public ResponseEntity<?> deleteBody(@PathVariable(value = "bodiesId") @Min(1) Integer bodiesId) {
        Body body = bodyService.findBodyByBodyId(bodiesId);
        if (body != null) {
            bodyService.deleteBody(body.getBodyId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new Response("Not found body"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/engines/{enginesId}")
    public ResponseEntity<?> deleteEngine(@PathVariable(value = "enginesId") @Min(1) Integer enginesId) {
        Engine engine = engineService.findEngineByEngineId(enginesId);
        if (engine != null) {
            engineService.deleteEngine(engine.getEngineId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new Response("Not found engine"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/details/{detailsId}")
    public ResponseEntity<?> deleteDetail(@PathVariable(value = "detailsId") @Min(1) Integer detailsId) {
        Detail detail = detailService.findDetailByDetailId(detailsId);
        if (detail != null) {
            detailService.deleteDetailByDetailId(detail.getDetailId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new Response("Not found detail"), HttpStatus.NOT_FOUND);
    }
}
