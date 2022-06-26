package com.sharko.articles.services;

import com.sharko.articles.models.Article;
import com.sharko.articles.repositories.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    public Article createNewArticle(Article article) throws Exception {
        try {
            return articleRepository.save(article);
        } catch (Exception e) {
            log.warn("Cannot create an article:{}", e.getMessage());
            throw new Exception(e);
        }
    }

    public int countOfArticlesIn7Days() {
        List<Article> result = articleRepository.findAllArticlesIn7Days();

        return result.size();
    }
}
