package com.example.shopinternet.controllers.search;

import com.example.shopinternet.controllers.body.request.CatalogType;
import com.example.shopinternet.controllers.body.resp.Response;
import com.example.shopinternet.detail.Detail;
import com.example.shopinternet.model.*;
import com.example.shopinternet.service.detail.DetailService;
import com.example.shopinternet.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1.0")
public class SearchDetailsFiveStepController {

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

    @GetMapping("/cars")
    public ResponseEntity<?> getCars() {
        List<Car> cars = carService.getAllCars();
        if (!cars.isEmpty()) {
            return new ResponseEntity<>(cars, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found"), HttpStatus.OK);
    }

    @GetMapping("/cars/{carId}/carModels")
    public ResponseEntity<?> getCarModelsByCarId(@PathVariable(value = "carId") Integer carId) {
        List<CarModel> carModels = carModelService.findCarModelsByCarId(carId);
        if (!carModels.isEmpty()) {
            return new ResponseEntity<>(carModels, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found"), HttpStatus.OK);
    }

    @GetMapping("/cars/carModels/{carModelId}/generations")
    public ResponseEntity<?> getGenerationsByCarModelId(@PathVariable(value = "carModelId") Integer carModelId) {
        List<Generation> generations = generationService.findGenerationsByCarModelId(carModelId);
        if (!generations.isEmpty()) {
            return new ResponseEntity<>(generations, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found"), HttpStatus.OK);
    }

    @GetMapping("/cars/carModels/generations/{generationId}/bodies")
    public ResponseEntity<?> getBodiesByGenerationId(@PathVariable(value = "generationId") Integer generationId) {
        List<Body> bodies = bodyService.findBodiesByGenerationId(generationId);
        if (!bodies.isEmpty()) {
            return new ResponseEntity<>(bodies, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found"), HttpStatus.OK);
    }

    @GetMapping("/cars/carModels/generations/bodies/{bodyId}/engines")
    public ResponseEntity<?> getEnginesByBodyId(@PathVariable(value = "bodyId") Integer bodyId) {
        List<Engine> engines = engineService.findEnginesByBodyId(bodyId);
        if (!engines.isEmpty()) {
            return new ResponseEntity<>(engines, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found"), HttpStatus.OK);
    }

    @GetMapping(value ="/cars/carModels/generations/bodies/engines/{engineId}/details")
    public ResponseEntity<?> getDetailsByEngineId(@PathVariable(value = "engineId") Integer engineId) {
        List<Detail> details = detailService.findDetailsByEngineId(engineId);
        if (!details.isEmpty()) {
            return new ResponseEntity<>(details, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found"), HttpStatus.OK);
    }

    @GetMapping(value = "/details")
    public ResponseEntity<?> getDetailsByCatalogType(@RequestBody CatalogType catalogType) {
        List<Detail> details = detailService.findDetailsByCatalogType(catalogType.getCatalogType());
        if (!details.isEmpty()) {
            return new ResponseEntity<>(details, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found"), HttpStatus.OK);
    }

}
