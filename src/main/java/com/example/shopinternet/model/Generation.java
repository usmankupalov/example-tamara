package com.example.shopinternet.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "generation")
@AllArgsConstructor
public class Generation {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "generation_id")
    private Integer generationId;

    @NotBlank
    @Column(name = "generation_name", nullable = false)
    private String generationName;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "car_model_id", nullable = false)
    private CarModel carModel;

    @OneToMany(mappedBy = "generation", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference
    private List<Body> body;

    public Generation() {}

    public Generation(String generationName, CarModel carModel) {
        this.generationName = generationName;
        this.carModel = carModel;
    }

    public Integer getGenerationId() {
        return generationId;
    }

    public void setGenerationId(Integer generationId) {
        this.generationId = generationId;
    }

    public String getGenerationName() {
        return generationName;
    }

    public void setGenerationName(String generationName) {
        this.generationName = generationName;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public List<Body> getBody() {
        return body;
    }

    public void setBody(List<Body> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Generation{" +
                "Id=" + generationId +
                ", Name='" + generationName + '\'' +
                '}';
    }
}
