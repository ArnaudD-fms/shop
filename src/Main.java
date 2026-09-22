import fr.fms.shop.dao.ArticleDao;
import fr.fms.shop.dao.ArticleDaoImpl;
import fr.fms.shop.model.Article;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        ArticleDao articleDao = new ArticleDaoImpl();

        Article article = articleDao.findById(1);
        System.out.println(article.getDescription() + " " + article.getBrand() + " " + article.getUnitaryPrice());

        article = articleDao.findById(2);
        System.out.println(article.getDescription() + " " + article.getBrand() + " " + article.getUnitaryPrice());
    }
}