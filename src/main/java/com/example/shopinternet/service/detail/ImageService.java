package com.example.shopinternet.service.detail;


import com.example.shopinternet.detail.Image;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface ImageService {
    void init();
    void save(MultipartFile file);
    Resource load(String fileName);
    Stream<Path> loadAll();
    void addImage(Image image);
    Image findImageByImageName(String imageName);
    List<Image> getImages();
}
