package ua.com.delivery;

import ua.com.delivery.persistence.dao.IAbstractFactory;
import ua.com.delivery.persistence.entity.Direction;
import ua.com.delivery.persistence.entity.User;
import ua.com.delivery.persistence.utilDao.SimpleConnection;
import ua.com.delivery.service.LoginService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    private static final String GET_USER_BY_USERNAME = "SELECT * FROM Users WHERE username=?";
    private static final String GET_LIST_DIRECTIONS = "SELECT * FROM Directions";
    private static final String GET_PRICE_LIST_DIRECTIONS = "SELECT from_city, to_city, price_direction FROM Directions";
    private static IAbstractFactory factory;
    public static void main(String[] args) {
        String abc = "mns";

        List<Direction> directionList = getListDirections();
        for (int i = 0; i < directionList.size(); i++) {
            if (directionList.equals("Lviv")){
                System.out.println("aaaaaa");
            } else {
                System.out.println("bbbbb");
            }
            System.out.println(directionList.get(i));
        }

        System.out.println(directionList.get(3));
//        System.out.println(getUserByUsername(abc));
//        checkUserPassword(getUserByUsername(abc), "dsaf");

//        User user = checkUserPassword(getUserByUsername(abc), "dmsw");
//        checkIfAdmin(user);
        ///////////////////////
//        List<Direction> list =getListDirections();
//        for (Direction d: list) {
//            System.out.println(d);
//        }
//        System.out.println(list.get(4));
        ///////////
    }

    public static List<Direction> getListDirections() {
        List<Direction> directionList = new ArrayList<>();
        Statement statement;
//        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
        try (Connection connection = SimpleConnection.getInstance().getConnection()) {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_LIST_DIRECTIONS);
            if (resultSet.next()) {
                do {
                    Direction direction = new Direction();
                    direction.setFromCity(resultSet.getString("from_city"));
                    directionList.add(direction);
                } while (resultSet.next());
            } else {
                System.out.println("Your list directions is empty");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return directionList;
    }

    public static List<Direction> getPriceListDirections() {
        List<Direction> directionList = new ArrayList<>();
        Statement statement;
//        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
        try (Connection connection = SimpleConnection.getInstance().getConnection()) {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_PRICE_LIST_DIRECTIONS);
            if (resultSet.next()) {
                do {
                    Direction direction = new Direction();
                    direction.setFromCity(resultSet.getString("from_city"));
                    direction.setToCity(resultSet.getString("to_city"));
                    direction.setPriceDirection(resultSet.getInt("price_direction"));
                    directionList.add(direction);
                } while (resultSet.next());
            } else {
                System.out.println("Your price list directions is empty");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return directionList;
    }

//    public static List<Direction> getListDirections() {
//        List<Direction> directionList = new ArrayList<>();
//        Statement statement;
//        //        try (Connection connection = ConnectionPool.getInstance().getConnection()){
//        try (Connection connection = SimpleConnection.getInstance().getConnection()) {
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(GET_LIST_DIRECTIONS);
//            if (resultSet.next()) {
//                do {
//                    Direction direction = new Direction();
//                    direction.setDirectionID(resultSet.getLong("directionID"));
//                    direction.setFromCity(resultSet.getString("from_city"));
//                    direction.setToCity(resultSet.getString("to_city"));
//                    direction.setPriceDirection(resultSet.getInt("price_direction"));
//                    directionList.add(direction);
//                } while (resultSet.next());
//            } else {
//                System.out.println("Your list directions is empty");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return directionList;
//    }


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
