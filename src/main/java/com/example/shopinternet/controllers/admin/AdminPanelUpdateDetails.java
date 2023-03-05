package com.example.shopinternet.controllers.admin;

import com.example.shopinternet.controllers.body.resp.Response;
import com.example.shopinternet.detail.Detail;
import com.example.shopinternet.detail.Image;
import com.example.shopinternet.dto.*;
import com.example.shopinternet.model.*;
import com.example.shopinternet.service.detail.DetailService;
import com.example.shopinternet.service.detail.ImageService;
import com.example.shopinternet.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1.0")
@Validated
public class AdminPanelUpdateDetails {

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

    @Autowired
    private ImageService imageService;

    @PutMapping("/cars")
    public ResponseEntity<?> updateCar(@Valid @RequestBody CarDto carDto) {
        Car car = carService.findCarByCarId(carDto.getCarId());
        if (car != null) {
            carService.updateCar(carDto.getCarName(), carDto.getCarId());
            return new ResponseEntity<>(car, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found car"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/carModels")
    public ResponseEntity<?> updateCarModel(@Valid @RequestBody CarModelDto carModelDto) {
        CarModel carModel = carModelService.findCarModelByCarModelId(carModelDto.getCarModelId());
        if (carModel != null) {
            carModelService.updateCarModel(carModelDto.getCarModelName(), carModelDto.getCarModelId());
            return new ResponseEntity<>(carModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found car model"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/generations")
    public ResponseEntity<?> updateGeneration(@Valid @RequestBody GenerationDto generationDto) {
        Generation generation = generationService.findGenerationByGenerationId(generationDto.getGenerationId());
        if (generation != null) {
            generationService.updateGeneration(generationDto.getGenerationName(), generationDto.getGenerationId());
            return new ResponseEntity<>(generation, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found generation"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/bodies")
    public ResponseEntity<?> updateBody(@Valid @RequestBody BodyDto bodyDto) {
        Body body = bodyService.findBodyByBodyId(bodyDto.getBodyId());
        if (body != null) {
            bodyService.updateBody(bodyDto.getBodyName(), bodyDto.getBodyId());
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found body"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/engines")
    public ResponseEntity<?> updateEngine(@Valid @RequestBody EngineDto engineDto) {
        Engine engine = engineService.findEngineByEngineId(engineDto.getEngineId());
        if (engine != null) {
            engineService.updateEngine(engineDto.getEngineName(), engineDto.getEngineId());
            return new ResponseEntity<>(engine, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found engine"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/details/{detailsId}")
    public ResponseEntity<?> updateDetail(@Valid DetailDto detailDto,
                                          @PathVariable(value = "detailsId") @Min(1) Integer detailsId,
                                          @RequestParam("file") MultipartFile file) throws IOException {
        Detail detail = detailService.findDetailByDetailId(detailsId);
        if (detail != null) {
            if (!file.isEmpty()) {
                try {
                    imageService.save(file);
                    Image image = new Image();
                    List<Image> images = imageService.loadAll().map(path -> {
                        String filename = path.getFileName().toString();
                        String url = MvcUriComponentsBuilder
                                .fromMethodName(AdminPanelAddDetailsController.class, "getImage", path.getFileName().toString()).build().toString();
                        image.setImageName(filename);
                        image.setImagePath(url);
                        imageService.addImage(image);
                        return image;
                    }).collect(Collectors.toList());
                    imageService.addImage(image);
                    detailService.updateDetail(detailDto.getDetailName(), detailDto.getPrice(), detailDto.getAmount(),
                            detailDto.getCatalogType(), detailDto.getVinNumber(), image, detailDto.getDetailId());
                    return new ResponseEntity<>(detail, HttpStatus.OK);
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e);
                }
            }
            return new ResponseEntity<>(new Response("File didn't passed"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Response("Not found detail"), HttpStatus.NOT_FOUND);
    }
}
