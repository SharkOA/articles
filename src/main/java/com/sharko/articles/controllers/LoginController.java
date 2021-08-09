package com.sharko.articles.controllers;

import com.sharko.articles.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String homepage() {
        return ("<h1>Homepage</h1>");
    }

    @GetMapping("/admin")
    public int admin() {
        return articleService.countOfArticlesIn7Days();
    }

}
