package com.example.shopinternet.controllers.search;

import com.example.shopinternet.controllers.body.resp.Response;
import com.example.shopinternet.detail.HitProduct;
import com.example.shopinternet.service.detail.CatalogService;
import com.example.shopinternet.service.detail.HitProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1.0")
public class HitProductController {

    @Autowired
    private HitProductService hitProductService;

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/hitProducts")
    public ResponseEntity<?> getHitProducts() {
        List<HitProduct> hitProducts = hitProductService.getHitProductsByRegisteredTime();
        if (!hitProducts.isEmpty()) {
            return new ResponseEntity<>(hitProducts, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Empty"), HttpStatus.OK);
    }
}
