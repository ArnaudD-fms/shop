import fr.fms.shop.dao.ArticleDao;
import fr.fms.shop.dao.ArticleDaoImpl;
import fr.fms.shop.model.Article;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        ArticleDao articleDao = new ArticleDaoImpl();

//        Article article = articleDao.findById(1);
//        System.out.println(article.getDescription() + " " + article.getBrand() + " " + article.getUnitaryPrice());
//
//        article = articleDao.findById(2);
//        System.out.println(article.getDescription() + " " + article.getBrand() + " " + article.getUnitaryPrice());
//
//        List<Article> articles = articleDao.findAll();
//
//        for (Article article : articles) {
//            System.out.println(article.getDescription() + " " + article.getBrand() + " " + article.getUnitaryPrice());
//        }
//
//        Article article = new Article("test_description", "test_brand", new BigDecimal("99.99"));
//        articleDao.save(article);
//
        Article article = new Article(
                "update_description",
                "update_brand",
                new BigDecimal("19.99"));
        article.setId(13);

        articleDao.update(article);
    }
}