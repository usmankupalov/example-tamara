package com.example.shopinternet.config;

import com.example.shopinternet.repository.detail.*;
import com.example.shopinternet.repository.model.*;
import com.example.shopinternet.service.detail.*;
import com.example.shopinternet.service.detail.impl.*;
import com.example.shopinternet.service.model.*;
import com.example.shopinternet.service.model.impl.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.example.shopinternet.service")
public class AppConfig {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public CarService carService(CarRepository carRepository) {
        return new CarServiceImpl(carRepository );
    }

    @Bean
    public CarModelService carModelService(CarModelRepository carModelRepository) {
        return new CarModelServiceImpl(carModelRepository);
    }

    @Bean
    public GenerationService generationService(GenerationRepository generationRepository) {
        return new GenerationServiceImpl(generationRepository);
    }

    @Bean
    public BodyService bodyService(BodyRepository bodyRepository) {
        return new BodyServiceImpl(bodyRepository);
    }

    @Bean
    public EngineService engineService(EngineRepository engineRepository) {
        return new EngineServiceImpl(engineRepository);
    }

    @Bean
    public DetailService detailService(DetailRepository detailRepository) {
        return new DetailServiceImpl(detailRepository);
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }

    @Bean
    public ImageService imageService(ImageRepository imageRepository) {
        return new ImageServiceImpl(imageRepository);
    }

    @Bean
    public HitProductService hitProductService(HitProductRepository hitProductRepository) {
        return new HitProductServiceImpl(hitProductRepository);
    }

    @Bean
    public CatalogService catalogService(CatalogRepository catalogRepository) {
        return new CatalogServiceImpl(catalogRepository);
    }
}
