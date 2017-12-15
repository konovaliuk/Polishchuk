package ua.com.delivery.persistence.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.IUserDao;
import ua.com.delivery.persistence.entity.User;
import ua.com.delivery.persistence.util.SimpleConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements IUserDao {
    private static final Logger LOGGER = Logger.getLogger(UserImpl.class);
    private static final String GET_LIST_USERS = "SELECT * FROM Users";
    private static final String GET_BY_ID = "SELECT * FROM Users WHERE userID=?";
    private static final String DELETE_USER_BY_USERNAME = "DELETE FROM Users WHERE username=?";
    private static final String UPDATE_DATA_USER = "UPDATE Users SET username=?, password=?, first_name=?," +
            "second_name=?, email=?, address=?, city=?, phone=? WHERE userID=?";
    private static final String CREATE_USER = "INSERT INTO Users (userID, username, password, first_name, second_name," +
            "email, address, city, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public void createUser(User user) {
//        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER)
        ) {
            //чи потрібно тут закривати connectionpool
            //чи він просто після опрацювання повертаєтсья в пул? - якщо через ConnectionPool
            preparedStatement.setLong(1, user.getUserID());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getSecondName());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, user.getCity());
            preparedStatement.setLong(9, user.getPhone());

            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("User " + user.getUsername() + " was created");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }

    @Override
    public List<User> getListUsers() {
        List<User> userList = new ArrayList<>();
//        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_LIST_USERS)
        ) {
            if (resultSet.next()) {
                do {
                    User user = new User();
                    user.setUserID(resultSet.getLong("userID"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setSecondName(resultSet.getString("second_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setAddress(resultSet.getString("address"));
                    user.setCity(resultSet.getString("city"));
                    user.setPhone(resultSet.getLong("phone"));
                    userList.add(user);
                } while (resultSet.next());
            } else {
                LOGGER.info("List Users is empty.");
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return userList;
    }

    @Override
    public User getById(Long id) {
        User user = new User();
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)
        ) {
            //вказую значення id, яке приходить до нас із параметра
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    user.setUserID(resultSet.getLong("userID"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setSecondName(resultSet.getString("second_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setAddress(resultSet.getString("address"));
                    user.setCity(resultSet.getString("city"));
                    user.setPhone(resultSet.getLong("phone"));
                    preparedStatement.executeUpdate();
                } while (resultSet.next());
            } else {
                LOGGER.info("No given id");
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DATA_USER)
        ) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getSecondName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getCity());
            preparedStatement.setLong(8, user.getPhone());
            preparedStatement.setLong(9, user.getUserID());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("User " + user.getUsername() + " was updated");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }

    @Override
    public void deleteUserByUsername(String username) {
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_USERNAME)
        ) {
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("User with username " + username + " was successful deleted.");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }
}
