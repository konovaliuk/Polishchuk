package ua.com.delivery;

import ua.com.delivery.persistence.entity.User;
import ua.com.delivery.persistence.utilDao.SimpleConnection;
import ua.com.delivery.service.LoginService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestClass {
    public static final String GET_USER_BY_USERNAME = "SELECT * FROM Users WHERE username=?";
    public static void main(String[] args) {
        String abc = "mns";


//        System.out.println(getUserByUsername(abc));
//        checkUserPassword(getUserByUsername(abc), "dsaf");

        User user = checkUserPassword(getUserByUsername(abc), "dmsw");
        checkIfAdmin(user);
    }
    public static User getUserByUsername(String username) {
        User user = new User();
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERNAME)
        ){
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {

                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setAdmin(resultSet.getBoolean("admin"));
                    preparedStatement.execute();
//                    preparedStatement.executeUpdate();
                } while (resultSet.next());
            } else {
                System.out.println("no given username");
            }
        } catch (SQLException e){
            System.out.println("sql exception");
            e.printStackTrace();
        }
        System.out.println(user.getUsername());
        return user;
    }

    public static User checkUserPassword(User user, String password) {
        String page;
        if (LoginService.getInstance().checkPasswordForUsername(user, password)){
            System.out.println("password is true: " + password);
        } else {
            System.out.println("password is wrong: " + password);
        }
        return user;

    }

    public static void checkIfAdmin (User user){
        String page;
        System.out.println(user.getAdmin());
        if (user.getAdmin()){
            System.out.println("it's an admin: " + user.getUsername());
        } else {
            System.out.println("it isn't admin: " + user.getUsername());
        }
    }

}
