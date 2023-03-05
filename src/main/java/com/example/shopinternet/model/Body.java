package com.example.shopinternet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "body")
@AllArgsConstructor
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "body_id")
    private Integer bodyId;

    @NotBlank
    @Column(name = "body_name", nullable = false)
    private String bodyName;

    @ManyToOne
    @JoinColumn(name = "generation_id", nullable = false)
    @JsonBackReference
    private Generation generation;

    @OneToMany(mappedBy = "body", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference
    private List<Engine> engines;

    public Body() {}

    public Body(String bodyName, Generation generation) {
        this.bodyName = bodyName;
        this.generation = generation;
    }

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public String getBodyName() {
        return bodyName;
    }

    public void setBodyName(String bodyName) {
        this.bodyName = bodyName;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }
}
