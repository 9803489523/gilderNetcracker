package com.spaskin.news.controllers;

import com.spaskin.news.entity.Image;
import com.spaskin.news.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alexanrd Spaskin
 */
@RestController
@RequestMapping("api/v1/image")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<?> cread(@RequestBody Image image){
        imageService.create(image);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Image>> read(){
        final List<Image> imageList = imageService.readAll();

        return imageList != null && !imageList.isEmpty()
                ? new ResponseEntity<>(imageList, HttpStatus.OK)
                : new ResponseEntity<>(imageList, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Image> read(@PathVariable(name = "id") String id){
        final Image image = imageService.read(id);

        return image != null
                ? new ResponseEntity<>(image, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody Image image){
        final boolean update = imageService.update(image, id);

        return  update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id){
        final boolean deleted = imageService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
