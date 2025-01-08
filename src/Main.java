import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        Connection dbConnection;

        try {
            String url = "jdbc:mysql://localhost:3306/contact";
            String user = "root";
            String password = "";
            dbConnection = DriverManager.getConnection(url, user, password);
            System.out.println("connexion bdd ok");

            User.getAllUsers(dbConnection).forEach(p -> System.out.println(p.getFirstname()));

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}