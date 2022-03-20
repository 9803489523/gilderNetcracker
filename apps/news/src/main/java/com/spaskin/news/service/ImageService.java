package com.spaskin.news.service;

import com.spaskin.news.entity.Image;
import com.spaskin.news.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alexanrd Spaskin
 */
@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public void create(Image image) {
        imageRepository.save(image);
    }

    public List<Image> readAll() {
        return imageRepository.findAll();
    }

    public Image read(String id) {
        return imageRepository.getOne(id);
    }

    public boolean update(Image image, String id) {
        if (imageRepository.existsById(id)){
            image.setName(id);
            imageRepository.save(image);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        if (imageRepository.existsById(id)){
            imageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
