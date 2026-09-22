package fr.fms.shop.dao;

import fr.fms.shop.config.DatabaseConnection;
import fr.fms.shop.model.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    @Override
    public void save(Article article) {

        String sql = "INSERT INTO t_articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?)";
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, article.getDescription());
            statement.setString(2, article.getBrand());
            statement.setBigDecimal(3, article.getUnitaryPrice());

            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()){

                if (resultSet.next()) {
                    int id = resultSet.getInt("IdArticle");
                    article.setId(id);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

        String sql = "UPDATE t_articles SET Description = ?, Brand = ?, UnitaryPrice = ? WHERE IdArticle = ?";
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, article.getDescription());
            statement.setString(2, article.getBrand());
            statement.setBigDecimal(3, article.getUnitaryPrice());
            statement.setInt(4, article.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String sql = "DELETE FROM t_articles WHERE IdArticle = ?";
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

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
