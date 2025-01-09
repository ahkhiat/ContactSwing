import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static Connection connection;

    public static void main(String[] args) {

        Connection dbConnection;

        try {
            dbConnection = DatabaseConnection.getConnection();
            System.out.println("Connexion BDD OK");

            new ContactFrame("Contacts", dbConnection);

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}