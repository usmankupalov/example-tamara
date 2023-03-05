package com.example.shopinternet.controllers.search;

import com.example.shopinternet.detail.Catalog;
import com.example.shopinternet.service.detail.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1.0")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity<?> getCatalogs() {
        List<Catalog> catalogs = catalogService.getCatalogs();
        if (!catalogs.isEmpty())
            return new ResponseEntity<>(catalogs, HttpStatus.OK);
        return new ResponseEntity<>(catalogs, HttpStatus.OK);
    }

}
