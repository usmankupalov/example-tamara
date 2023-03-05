package com.example.shopinternet.controllers.admin;

import com.example.shopinternet.controllers.body.resp.Response;
import com.example.shopinternet.detail.Catalog;
import com.example.shopinternet.detail.HitProduct;
import com.example.shopinternet.service.detail.CatalogService;
import com.example.shopinternet.service.detail.HitProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.io.IOException;

@RestController
@RequestMapping("/v1.0")
@Validated
public class AdminPanelHitProduct {

    @Autowired
    private HitProductService hitProductService;

    @Autowired
    private CatalogService catalogService;

    @PostMapping("/hitProducts/{catalogsId}")
    public ResponseEntity<?> addHitProduct(@PathVariable(value = "catalogsId") @Min(1) Integer catalogsId) throws IOException {
        Catalog catalog = catalogService.findCatalogByCatalogId(catalogsId);
        if (catalog != null) {
            HitProduct hitProduct = new HitProduct();
            hitProduct.setCatalog(catalog);
            hitProductService.addHitProduct(hitProduct);
            return new ResponseEntity<>(hitProduct, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Response("Catalog not found"), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/hitProducts/{hitProductsId}")
    public ResponseEntity<?> deleteHitProduct(@PathVariable(value = "hitProductsId") @Min(1) Integer hitProductsId) {
        HitProduct hitProduct = hitProductService.findHitProductByHitProductId(hitProductsId);
        if (hitProduct != null) {
            hitProductService.deleteHitProduct(hitProduct.getHitProductId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new Response("Not found detail"), HttpStatus.NOT_FOUND);
    }
}
