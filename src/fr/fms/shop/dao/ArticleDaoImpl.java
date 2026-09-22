package fr.fms.shop.dao;

import fr.fms.shop.config.DatabaseConnection;
import fr.fms.shop.model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    @Override
    public void save(Article article) {

    }

    @Override
    public Article findById(int id) {

        String sql = "SELECT * FROM t_articles WHERE IdArticle = ?";
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return  mapResultSetToArticle(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Article> findAll() {

        String sql = "SELECT * FROM t_articles";

                try (
                        Connection connection = DatabaseConnection.getConnection();
                        PreparedStatement statement = connection.prepareStatement(sql)
                ) {

                    try (ResultSet resultSet = statement.executeQuery()) {

                        List<Article> articles = new ArrayList<>();

                        while (resultSet.next()) {
                            articles.add(mapResultSetToArticle(resultSet));
                        }

                        return articles;
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

        return Collections.emptyList();
    }

    @Override
    public void update(Article article) {

    }

    @Override
    public void delete(int id) {

    }

    private static Article mapResultSetToArticle(ResultSet resultSet) throws SQLException {
        Article article = new Article(
                resultSet.getString("Description"),
                resultSet.getString("Brand"),
                resultSet.getBigDecimal("UnitaryPrice")
        );

        article.setId(resultSet.getInt("IdArticle"));
        article.setIdCategory(resultSet.getInt("IdCategory"));
        return article;
    }

}
