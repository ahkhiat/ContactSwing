import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static Connection connection;

    public static void main(String[] args) {

        connection = DatabaseConnection.getConnection();
//        Connection dbConnection;
//
//        try {
//            dbConnection = DatabaseConnection.getConnection();
//            System.out.println("Connexion BDD OK");
//
//            User.getAllUsers(dbConnection).forEach(p -> System.out.println(p.getFirstname()));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        new ContactFrame("Contacts", connection);



    }
}