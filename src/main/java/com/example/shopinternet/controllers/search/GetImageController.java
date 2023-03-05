package com.example.shopinternet.controllers.search;

import com.example.shopinternet.detail.Image;
import com.example.shopinternet.service.detail.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/static")
@Validated
public class GetImageController {

    @Autowired
    private ImageService imageService;

//    @ResponseBody
//    @GetMapping("/{imageName}")
//    public ResponseEntity<byte[]> getImageWithMediaType(@PathVariable(value = "imageName") @NotBlank String imageName) throws IOException {
//        byte image[] = downloadImage(imageName);
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpg")).body(image);
//    }
//
//    private byte[] downloadImage(String imageName) throws IOException {
//        Image image = imageService.findImageByImageName(imageName);
//        if (image != null) {
//            String fullPath = image.getImagePath();
//            return Files.readAllBytes(new File(fullPath).toPath());
//        }
//        return null;
//    }
}
