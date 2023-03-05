package com.example.shopinternet.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "car_model")
@AllArgsConstructor
public class CarModel {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "car_model_id")
    private Integer carModelId;

    @NotBlank
    @Column(name = "car_model_name", nullable = false)
    private String carModelName;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    @JsonBackReference
    private Car car;

    @OneToMany(mappedBy = "carModel", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference
    private List<Generation> generation;

    public CarModel() {}

    public CarModel(String carModelName, Car car) {
        this.carModelName = carModelName;
        this.car = car;
    }

    public Integer getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(Integer carModelId) {
        this.carModelId = carModelId;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Generation> getGeneration() {
        return generation;
    }

    public void setGeneration(List<Generation> generation) {
        this.generation = generation;
    }

}
