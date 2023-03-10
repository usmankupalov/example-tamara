package com.example.shopinternet.controllers.admin;

import com.example.shopinternet.controllers.body.resp.Response;
import com.example.shopinternet.detail.Catalog;
import com.example.shopinternet.detail.Image;
import com.example.shopinternet.dto.CatalogDto;
import com.example.shopinternet.service.detail.CatalogService;
import com.example.shopinternet.service.detail.ImageService;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/v1.0")
@Validated
public class AdminPanelCatalog {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ImageService imageService;

    private final Path root = Paths.get("images");

    @PostMapping("/catalogs")
    public ResponseEntity<?> addCatalog(Catalog catalog, @RequestParam("file") MultipartFile file) throws IOException {
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

                catalog.setImage(image);
                catalogService.addCatalog(catalog);
                return new ResponseEntity<>(catalog, HttpStatus.CREATED);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e);
            }
        }
        return new ResponseEntity<>(new Response("File didn't passed"), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/catalogs/{catalogsId}")
    public ResponseEntity<?> updateCatalog(@Valid CatalogDto catalogDto,
                                           @PathVariable(value = "catalogsId") @Min(1) Integer catalogsId,
                                           @RequestParam("file") MultipartFile file) throws IOException {
        Catalog catalog = catalogService.findCatalogByCatalogId(catalogsId);
        if (catalog != null) {
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
                    catalogService.updateCatalog(catalogDto.getCatalogName(), catalogDto.getPrice(), catalogDto.getAmount(),
                            catalogDto.getCatalogType(), image, catalogsId);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e);
                }
            } return new ResponseEntity<>(new Response("File didn't passed"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Response("Not found catalog"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/catalogs/{catalogsId}")
    public ResponseEntity<?> deleteCatalog(@PathVariable(value = "catalogsId") @Min(1) Integer catalogsId) {
        Catalog catalog = catalogService.findCatalogByCatalogId(catalogsId);
        if (catalog != null) {
            catalogService.deleteCatalogByCatalogId(catalog.getCatalogId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new Response("Not found catalog"), HttpStatus.NOT_FOUND);
    }


}
