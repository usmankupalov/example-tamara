package com.example.shopinternet.controllers.order;

import com.example.shopinternet.controllers.body.resp.Response;
import com.example.shopinternet.model.Order;
import com.example.shopinternet.model.User;
import com.example.shopinternet.service.model.OrderService;
import com.example.shopinternet.service.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0")
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

}
