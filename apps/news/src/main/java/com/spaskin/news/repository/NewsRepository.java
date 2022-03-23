package com.spaskin.news.repository;

import com.spaskin.news.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alexanrd Spaskin
 */
public interface NewsRepository extends JpaRepository<News, Integer> {
}
