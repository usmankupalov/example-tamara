package com.example.shopinternet.controllers.search;

import com.example.shopinternet.controllers.body.request.VinNumber;
import com.example.shopinternet.controllers.body.resp.Response;
import com.example.shopinternet.detail.*;
import com.example.shopinternet.service.detail.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1.0")
@Validated
public class ButtonController {

    @Autowired
    private DetailService detailService;

    @GetMapping("/search/details")
    public ResponseEntity<?> searchCatalogByWinNumber(@Valid @RequestBody VinNumber vinNumber) {
        Detail detail = detailService.findDetailByVinNumber(vinNumber.getVinNumber());
        if (detail != null) {
            return new ResponseEntity<>(detail, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Not found"), HttpStatus.NOT_FOUND);
    }
}
