package fr.fms.shop.dao;

import fr.fms.shop.model.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDao {

    void save(Article article);

    Article findById(int id) throws SQLException;

    List<Article> findAll();

    void update(Article article);

    void delete(int id);
}
