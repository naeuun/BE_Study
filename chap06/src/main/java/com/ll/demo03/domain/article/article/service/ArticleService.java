package com.ll.demo03.domain.article.article.service;

import com.ll.demo03.domain.article.article.entity.Article;
import com.ll.demo03.domain.article.article.repository.ArticleRepository;
import com.ll.demo03.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    public final ArticleRepository articleRepository;

    public long count() {
        return articleRepository.count();
    }

    // 리턴
    // - 이번에 생성된 게시물의 번호
    // - 게시물 생성에 대한 결과 메시지
    // - 결과 코드
    // - 실패 하는 경우 예시 : 10 분 안에 게시물 5새 이상 작성 불가
    public RsData<Article> write(String title, String body) {
        Article article = Article
                .builder()
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);
        return RsData.of("%d번 게시물이 작성되었습니다.".formatted(article.getId()), article);
        // return RsData.OK; - data 가 필요 없을 때 & 단순히 메시지/상태코드만 필요할 때
    }

    public void delete(Article article){
        articleRepository.delete(article);
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
