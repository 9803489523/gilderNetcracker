package com.spaskin.news.controllers;

import com.spaskin.news.entity.News;
import com.spaskin.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alexanrd Spaskin
 */
@RestController
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService){
        this.newsService = newsService;
    }

    @PostMapping(value = "/news")
    public ResponseEntity<?> create(@RequestBody News news){
        newsService.create(news);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "news")
    public ResponseEntity<List<News>> read(){
        final List<News> newsList = newsService.readAll();

        return newsList != null && !newsList.isEmpty()
                ? new ResponseEntity<>(newsList, HttpStatus.OK)
                : new ResponseEntity<>(newsList, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/news/{id}")
    public ResponseEntity<News> read(@PathVariable(name = "id") int id){
        final News news = newsService.read(id);

        return news != null
                ? new ResponseEntity<>(news, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/news/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody News news){
        final boolean update = newsService.update(news, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/news/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = newsService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
