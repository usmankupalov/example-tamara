package com.example.shopinternet.controllers.admin;

import com.example.shopinternet.controllers.body.request.AddModel;
import com.example.shopinternet.controllers.body.resp.Response;
import com.example.shopinternet.detail.*;
import com.example.shopinternet.model.*;
import com.example.shopinternet.service.detail.*;
import com.example.shopinternet.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.constraints.Min;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1.0")
@Validated
public class AdminPanelAddDetailsController {

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

    private final Path root = Paths.get("images");

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/models")
    public ResponseEntity<?> add(@RequestBody AddModel requestAdding) {
        Car car = carService.findCarByCarName(requestAdding.getCarName());
        if (car != null) {
            CarModel carModel = carModelService.findCarModelByCarModelName(requestAdding.getCarModelName());
            if (carModel != null) {
                carModel.setCar(car);
                Generation generation = generationService.findGenerationByName(requestAdding.getGenerationName());
                if (generation != null) {
                    generation.setCarModel(carModel);
                    Body body = bodyService.findBodyName(requestAdding.getBodyName());
                    if (body != null) {
                        body.setGeneration(generation);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                    else {
                        body = new Body(requestAdding.getBodyName(), generation);
                        bodyService.addBody(body);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                }
                else {
                    generation = new Generation(requestAdding.getGenerationName(), carModel);
                    generationService.addGeneration(generation);
                    Body body = bodyService.findBodyName(requestAdding.getBodyName());
                    if (body != null) {
                        body.setGeneration(generation);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                    else {
                        body = new Body(requestAdding.getBodyName(), generation);
                        bodyService.addBody(body);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                        else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                }
            }
            else {
                carModel = new CarModel(requestAdding.getCarModelName(), car);
                carModelService.addCarModel(carModel);
                Generation generation = generationService.findGenerationByName(requestAdding.getGenerationName());
                if (generation != null) {
                    generation.setCarModel(carModel);
                    Body body = bodyService.findBodyName(requestAdding.getBodyName());
                    if (body != null) {
                        body.setGeneration(generation);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    } else {
                        body = new Body(requestAdding.getBodyName(), generation);
                        bodyService.addBody(body);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                }
                else {
                    generation = new Generation(requestAdding.getGenerationName(), carModel);
                    generationService.addGeneration(generation);
                    Body body = bodyService.findBodyName(requestAdding.getBodyName());
                    if (body != null) {
                        body.setGeneration(generation);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                    else {
                        body = new Body(requestAdding.getBodyName(), generation);
                        bodyService.addBody(body);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                        else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                }
            }
        }


        else {
            car = new Car(requestAdding.getCarName());
            carService.addCar(car);
            CarModel carModel = carModelService.findCarModelByCarModelName(requestAdding.getCarModelName());
            if (carModel != null) {
                carModel.setCar(car);
                Generation generation = generationService.findGenerationByName(requestAdding.getGenerationName());
                if (generation != null) {
                    generation.setCarModel(carModel);
                    Body body = bodyService.findBodyName(requestAdding.getBodyName());
                    if (body != null) {
                        body.setGeneration(generation);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                        else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                        }
                    }
                    else {
                        body = new Body(requestAdding.getBodyName(), generation);
                        bodyService.addBody(body);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                }
                else {
                    generation = new Generation(requestAdding.getGenerationName(), carModel);
                    generationService.addGeneration(generation);
                    Body body = bodyService.findBodyName(requestAdding.getBodyName());
                    if (body != null) {
                        body.setGeneration(generation);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    } else {
                        body = new Body(requestAdding.getBodyName(), generation);
                        bodyService.addBody(body);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                }
            }
            else {
                carModel = new CarModel(requestAdding.getCarModelName(), car);
                carModelService.addCarModel(carModel);
                Generation generation = generationService.findGenerationByName(requestAdding.getGenerationName());
                if (generation != null) {
                    generation.setCarModel(carModel);
                    Body body = bodyService.findBodyName(requestAdding.getBodyName());
                    if (body != null) {
                        body.setGeneration(generation);
                        bodyService.addBody(body);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    } else {
                        body = new Body(requestAdding.getBodyName(), generation);
                        bodyService.addBody(body);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                } else {
                    generation = new Generation(requestAdding.getGenerationName(), carModel);
                    generationService.addGeneration(generation);
                    Body body = bodyService.findBodyName(requestAdding.getBodyName());
                    if (body != null) {
                        body.setGeneration(generation);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    } else {
                        body = new Body(requestAdding.getBodyName(), generation);
                        bodyService.addBody(body);
                        Engine engine = engineService.findEngineByEngineName(requestAdding.getEngineName());
                        if (engine != null) {
                            engine.setBody(body);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        } else {
                            engine = new Engine(requestAdding.getEngineName(), body);
                            engineService.addEngine(engine);
                            return new ResponseEntity<>(new Response("Added"), HttpStatus.OK);
                        }
                    }
                }
            }
        }
        return new ResponseEntity<>(new Response("Missed detail name"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/details/{enginesId}")
    public ResponseEntity<?> addDetails(Detail detail,
                                            @PathVariable(value = "enginesId") @Min(1) Integer enginesId,
                                            @RequestParam("file") MultipartFile file) throws IOException {
        Engine engine = engineService.findEngineByEngineId(enginesId);
        if (engine != null) {
            if (!file.isEmpty()) {
                try {
                    String uuidFile = UUID.randomUUID().toString();
                    String filename = uuidFile + "." + "jpg";
                    Files.copy(file.getInputStream(), this.root.resolve(filename));
                    Image image = new Image();
                    String url = MvcUriComponentsBuilder
                            .fromMethodName(AdminPanelAddDetailsController.class,
                                    "getImage", filename).build().toString();
                    image.setImageName(filename);
                    image.setImagePath(url);
                    imageService.addImage(image);
                    detail.setEngine(engine);
                    detail.setImage(image);
                    detailService.addDetail(detail);
                    return new ResponseEntity<>(detail, HttpStatus.CREATED);
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e);
                }
            }
            return new ResponseEntity<>(new Response("File didn't passed"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Response("Engine not found"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/images/{imageName}")
    public ResponseEntity<?> getImage(@PathVariable(value = "imageName") String imageName) {
        Resource image = imageService.load(imageName);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

}
