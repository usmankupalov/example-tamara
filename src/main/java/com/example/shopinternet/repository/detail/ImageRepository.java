package com.example.shopinternet.repository.detail;

import com.example.shopinternet.detail.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    Image findImageByImageName(String imageName);
}
