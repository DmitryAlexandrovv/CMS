package ru.kpfu.alexandrov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kpfu.alexandrov.model.Article;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcArticleDao implements ArticleDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Article find(int id) {
        Article article = jdbcTemplate.queryForObject(
                "select * from article where id = ?",
                new Object[]{id},
                (ResultSet rs, int rowNum) -> {
                    Article article1 = new Article();
                    article1.setId(rs.getInt("id"));
                    article1.setDate(rs.getInt("publicationDate"));
                    article1.setTitle(rs.getString("title"));
                    article1.setContent(rs.getString("content"));
                    return article1;
                }
        );
        return article;
    }

    @Override
    public Article find(long publicationDate) {
        return null;
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = new ArrayList<>();
        List<Map<String, Object>> articlesFromDb = jdbcTemplate.queryForList("select * from article");

        for(int i = 0; i < articlesFromDb.size(); i++){
            articles.add(new Article((int)articlesFromDb.get(i).get("id"), (Long)articlesFromDb.get(i).get("publicationDate"), (String)articlesFromDb.get(i).get("title"), (String)articlesFromDb.get(i).get("content")));
        }

        return articles;
    }

    @Override
    public boolean put(Article article) {
        System.out.println(article.getContent());
         jdbcTemplate.update(
        "INSERT INTO article (title, content, publicationdate, parentId) VALUES (?, ?, ?, ?)",
             article.getTitle(), article.getContent(), article.getDate(), article.getParentId()
        );

        return true;
    }
}
