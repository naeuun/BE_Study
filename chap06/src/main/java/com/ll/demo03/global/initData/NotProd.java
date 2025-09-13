package com.ll.demo03.global.initData;

import com.ll.demo03.domain.article.article.entity.Article;
import com.ll.demo03.domain.article.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// !prod : dev or test
@Profile("!prod")
@Configuration
@RequiredArgsConstructor
public class NotProd {
    private final ArticleRepository articleRepository;
    @Bean
    public ApplicationRunner initNotprod() {
        return args -> {
            System.out.println("NotProd.initNotprod1");
            System.out.println("NotProd.initNotprod2");
            System.out.println("NotProd.initNotprod3");

            Article article1 = Article.builder()
                    .title("제목1")
                    .body("내용1")
                    .build();

            Article article2 = Article.builder()
                    .title("제목2")
                    .body("내용2")
                    .build();
            System.out.println("article1.id : " + article1.getId());
            System.out.println("article2.id : " + article2.getId());
            articleRepository.save(article1);
            articleRepository.save(article2);
            System.out.println("article1.id : " + article1.getId());
            System.out.println("article2.id : " + article2.getId());
        };
    }
}
