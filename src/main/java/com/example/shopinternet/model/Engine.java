package com.example.shopinternet.model;

import com.example.shopinternet.detail.Detail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "engine")
@AllArgsConstructor
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engine_id")
    private Integer engineId;

    @NotBlank
    @Column(name = "engine_name", nullable = false)
    private String engineName;

    @ManyToOne
    @JoinColumn(name = "body_id", nullable = false)
    @JsonBackReference
    private Body body;


    @OneToMany(mappedBy = "engine" , cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference
    private List<Detail> details;

    public Engine() {}

    public Engine(String engineName, Body body) {
        this.engineName = engineName;
        this.body = body;
    }

    public Integer getEngineId() {
        return engineId;
    }

    public void setEngineId(Integer engineId) {
        this.engineId = engineId;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
