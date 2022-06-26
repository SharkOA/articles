package com.sharko.articles.repositories;

import com.sharko.articles.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("select a from articles a where ((month(a.publishing_date) * 30 + day(a.publishing_date) + 7) > month(now()) * 30 + day(now()))")
    List<Article> findAllArticlesIn7Days();
}
