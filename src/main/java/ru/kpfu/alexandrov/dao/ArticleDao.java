package ru.kpfu.alexandrov.dao;

import org.springframework.stereotype.Repository;
import ru.kpfu.alexandrov.model.Article;

import java.util.List;

@Repository
public interface ArticleDao {
    Article find(int id);
    Article find(long publicationDate);
    List<Article> getAll();
    boolean put(Article article);
}
