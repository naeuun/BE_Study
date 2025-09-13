package com.ll.demo03.domain.article.article.repository;

import com.ll.demo03.domain.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    // 실제로 쓰이지는 않음, JAP 학습용
    List<Article> findByIdInOrderByTitleDescIdAsc(List<Long> ids);
    List<Article> findByTitleContaining(String title);
    List<Article> findByTitleAndBody(String title, String body);
}
