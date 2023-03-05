package com.example.shopinternet;

import com.example.shopinternet.service.detail.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ShopInternetApplication implements CommandLineRunner {

    @Resource
    private ImageService imageService;

    public static void main(String[] args) {
        SpringApplication.run(ShopInternetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        imageService.init();
    }
}
