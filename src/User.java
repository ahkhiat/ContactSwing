import java.sql.*;
import java.util.ArrayList;

public class User {

    long id;
    String firstname;
    String lastname;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public static ArrayList<User> getAllUsers(Connection connection) throws SQLException {

        ArrayList <User> users = new ArrayList<>();

        String query = "SELECT * FROM user";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));

            users.add(user);
        }

        rs.close();
        statement.close();
        return users;
    }



    public static void addPers(Connection connection, User personne) throws SQLException {
        String query = "INSERT INTO personne (nom_personne, prenom_personne) " +
                "VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, personne.getFirstname());
        preparedStatement.setString(2, personne.getLastname());

        preparedStatement.executeUpdate();

        preparedStatement.close();

    }

}
