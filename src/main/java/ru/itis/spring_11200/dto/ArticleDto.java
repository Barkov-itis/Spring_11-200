package ru.itis.spring_11200.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.spring_11200.models.Article;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String text;
    private String authorName;
    private Integer likeCount;

    public static ArticleDto from(Article article) {
        return ArticleDto.builder()
                .id(article.getArticle_id())
                .text(article.getText())
                .authorName(article.getAuthor().getEmail())
                .likeCount(article.getLikes().size())
                .build();
    }

    public static List<ArticleDto> articleList(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
