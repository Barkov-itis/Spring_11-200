package ru.itis.spring_11200.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_11200.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
