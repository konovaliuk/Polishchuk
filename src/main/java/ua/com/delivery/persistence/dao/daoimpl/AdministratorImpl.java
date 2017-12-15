package ua.com.delivery.persistence.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.IAdministratorDao;
import ua.com.delivery.persistence.entity.Administrator;
import ua.com.delivery.persistence.util.SimpleConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorImpl implements IAdministratorDao {
    private static final Logger LOGGER = Logger.getLogger(AdministratorImpl.class);
    private static final String GET_BY_ID = "SELECT * FROM Administrator WHERE adminID=?";
    private static final String GET_LIST_ADMINISTRATORS = "SELECT * FROM Administrator";
    private static final String DELETE_ADMINISTRATOR_BY_USERNAME = "DELETE FROM Administrator WHERE username=?";
    private static final String UPDATE_DATA_ADMINISTRATOR = "UPDATE Administrator SET name=?, username=?, password=?," +
            "email=?, phone=? WHERE adminID=?";
    private static final String CREATE_ADMINISTRATOR = "INSERT INTO Administrator (adminID, name, username, password, " +
            "email, phone) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public void createAdministrator(Administrator administrator) {
        if (administrator.getAdminID() != null) {
            LOGGER.info("Administrator is already created, the adminID is not null.");
        } else {
//        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            try (Connection connection = SimpleConnection.getInstance().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ADMINISTRATOR)
            ) {  //чи потрібно тут закривати connection
                //чи він просто після опрацювання повертаєтсья в пул? - якщо через ConnectionPool
                preparedStatement.setLong(1, administrator.getAdminID());
                preparedStatement.setString(2, administrator.getName());
                preparedStatement.setString(3, administrator.getUsername());
                preparedStatement.setString(4, administrator.getPassword());
                preparedStatement.setString(5, administrator.getEmail());
                preparedStatement.setLong(6, administrator.getPhone());
                preparedStatement.executeUpdate();
                connection.commit();
                LOGGER.info("Administrator " + administrator.getName() + " was created");
            } catch (SQLException e) {
                LOGGER.error(e.toString());
            }
        }
    }

    @Override
    public List<Administrator> getListAdministrators() {
        List<Administrator> administratorList = new ArrayList<>();
//        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_LIST_ADMINISTRATORS)
        ) {
            if (resultSet.next()) {
                do {
                    Administrator administrator = new Administrator();
                    administrator.setAdminID(resultSet.getLong("adminID"));
                    administrator.setName(resultSet.getString("name"));
                    administrator.setUsername(resultSet.getString("username"));
                    administrator.setPassword(resultSet.getString("password"));
                    administrator.setEmail(resultSet.getString("email"));
                    administrator.setPhone(resultSet.getLong("phone"));
                    administratorList.add(administrator);
                } while (resultSet.next());
            } else {
                LOGGER.info("List Administrators is empty.");
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return administratorList;
    }

    @Override
    public Administrator getById(Long id) {
        Administrator administrator = new Administrator();
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            //вказую значення id, яке приходить до нас із параметра
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    administrator.setAdminID(resultSet.getLong("adminID"));
                    administrator.setName(resultSet.getString("name"));
                    administrator.setUsername(resultSet.getString("username"));
                    administrator.setPassword(resultSet.getString("password"));
                    administrator.setEmail(resultSet.getString("email"));
                    administrator.setPhone(resultSet.getLong("phone"));

                    preparedStatement.executeUpdate();
                } while (resultSet.next());
            } else {
                LOGGER.info("No given id");
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return administrator;
    }

    @Override
    public void updateAdministrator(Administrator administrator) {
        if (administrator.getAdminID() == null) {
            LOGGER.info("Administrator is not created yet, the adminID is null.");
        } else {
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            try (Connection connection = SimpleConnection.getInstance().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DATA_ADMINISTRATOR)
            ) {

                preparedStatement.setString(1, administrator.getName());
                preparedStatement.setString(2, administrator.getUsername());
                preparedStatement.setString(3, administrator.getPassword());
                preparedStatement.setString(4, administrator.getEmail());
                preparedStatement.setLong(5, administrator.getPhone());
                preparedStatement.setLong(6, administrator.getAdminID());
                preparedStatement.executeUpdate();
                connection.commit();
                LOGGER.info("Administrator " + administrator.getName() + " was updated");
            } catch (SQLException e) {
                LOGGER.error(e.toString());
            }
        }
    }

    @Override
    public void deleteAdministratorByUsername(String username) {
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADMINISTRATOR_BY_USERNAME)
        ) {
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Administrator with username " + username + " was successful deleted.");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }
}
