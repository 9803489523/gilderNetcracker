package com.spaskin.news.service;

import com.spaskin.news.entity.News;
import com.spaskin.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alexanrd Spaskin
 */
@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public void create(News news) {
        newsRepository.save(news);
    }

    public List<News> readAll() {
        return newsRepository.findAll();
    }

    public News read(int id) {
        return newsRepository.getOne(id);
    }

    public boolean update(News news, int id) {
        if (newsRepository.existsById(id)){
            news.setNewsId(id);
            newsRepository.save(news);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (newsRepository.existsById(id)){
            newsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
