package com.example.dreamshop.services.Image;

import com.example.dreamshop.dto.ImageDto;
import com.example.dreamshop.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    void updateImage(MultipartFile file, Long imageId);
    List<ImageDto> saveImages(List<MultipartFile> files, Long productId);
}
