package com.ll.demo03.global.initData;

import com.ll.demo03.domain.article.article.entity.Article;
import com.ll.demo03.domain.article.article.service.ArticleService;
import com.ll.demo03.domain.member.member.entity.Member;
import com.ll.demo03.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// !prod : dev or test
@Profile("!prod")
@Configuration
@RequiredArgsConstructor
public class NotProd {
    @Lazy
    @Autowired
    private NotProd self;
    private final MemberService memberService;
    private final ArticleService articleService;

    @Bean
    public ApplicationRunner initNotprod() {
        return args -> {
            self.work1();
            self.work2();
        };
    }

    @Transactional
    public void work1() {
        if( articleService.count() >0 ) return;

        Member member1 = memberService.join("user1", "1234", "유저 1").getData();
        Member member2 = memberService.join("user2", "1234", "유저 2").getData();

        //RsData<Article> write = articleService.write("제목 1", "내용 1");
        //Article article1 = write.getData();
        // 이렇게 할 수도 있고 아래처럼 같이 넣을 수도 있음

        Article article1 = articleService.write("제목 1", "내용 1").getData();
        Article article2 = articleService.write("제목 2", "내용 2").getData();

        article2.setTitle("제목!");

        articleService.delete(article1);
    }

    @Transactional
    public void work2() {
        // List : 0~N
        // Optional : 0~1
        Article article = articleService.findById(2L).get();
        List<Article> articles = articleService.findAll();
    }
}
