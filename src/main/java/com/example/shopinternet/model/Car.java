package com.example.shopinternet.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer carId;

    @NotBlank
    @Column(name = "car_name", nullable = false, unique = true)
    private String carName;

    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference
    private List<CarModel> carModel;

    public Car() {}

    public Car(String carName) {
        this.carName = carName;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public List<CarModel> getCarModel() {
        return carModel;
    }

    public void setCarModel(List<CarModel> carModel) {
        this.carModel = carModel;
    }

}
