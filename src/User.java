import java.sql.*;
import java.util.ArrayList;

public class User {

    long id;
    String firstname;
    String lastname;
    String phone;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // NE PAS FAIRE CA !!
    // Mettre les méthodes d'acces aux données dans une autre classe
    public static ArrayList<User> getAllUsers(Connection connection) throws SQLException {

        ArrayList <User> usersList = new ArrayList<>();

        String query = "SELECT * FROM user";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setPhone(rs.getString("phone"));

            usersList.add(user);
        }

        rs.close();
        statement.close();
        return usersList;
    }

    public static void addUser(Connection connection, User user) throws SQLException {
        String query = "INSERT INTO user (firstname, lastname, phone) " +
                "VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, user.getFirstname());
        preparedStatement.setString(2, user.getLastname());
        preparedStatement.setString(3, user.getPhone());

        preparedStatement.executeUpdate();

        preparedStatement.close();

    }

}
