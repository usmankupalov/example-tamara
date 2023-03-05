package com.example.shopinternet.detail;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_path")
    private String imagePath;

    public  Image(){}

    public Image(String imageName, String imagePath) {
        this.imageName = imageName;
        this.imagePath = imagePath;
    }
}
