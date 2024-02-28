package ru.itis.spring_11200.services;

import ru.itis.spring_11200.dto.ArticleDto;
import ru.itis.spring_11200.dto.ArticleForm;

import java.util.List;

public interface ArticleService {
    ArticleDto addArticle(Long userId, ArticleForm articleForm);

    List<ArticleDto> getByUser(Long id);

    ArticleDto like(Long userId, Long articleId);
}
