package com.sharko.articles.controllers;

import com.sharko.articles.models.Article;
import com.sharko.articles.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity findAllArticles() {
        List<Article> allArticles = articleService.findAllArticles();

        return ResponseEntity.ok(allArticles);
    }

    @PostMapping("/create")
    public ResponseEntity createArticle(@RequestBody Article article) {
        try {
            Article newArticle = articleService.createNewArticle(article);

            return ResponseEntity.ok(newArticle);
        } catch (Exception e) {
            log.warn("Controller: Bad request {}", e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
