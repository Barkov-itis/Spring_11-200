package ru.itis.spring_11200.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.spring_11200.models.Article;
import ru.itis.spring_11200.models.User;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    boolean existsByArticleIdAndLikesContaining(Long articleId, User user);
}
