import fr.fms.shop.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = DatabaseConnection.getConnection()) {

            System.out.println("Connexion à MariaDB réussie !");

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}