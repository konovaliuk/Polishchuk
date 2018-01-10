package ua.com.delivery.persistence.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.IDirectionDao;
import ua.com.delivery.persistence.entity.Direction;
import ua.com.delivery.persistence.utilDao.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectionImpl implements IDirectionDao {
    private static final Logger LOGGER = Logger.getLogger(DirectionImpl.class);
    private static final String GET_LIST_DIRECTIONS = "SELECT * FROM Directions WHERE directionID IN(1,4,7,10)";
    private static final String GET_PRICE_LIST_DIRECTIONS = "SELECT * FROM Directions";
    private static final String GET_DIRECTION_BY_FROM_CITY = "SELECT * FROM Directions WHERE from_city=?";
    private static final String DELETE_DIRECTION_BY_ID = "DELETE FROM Directions WHERE directionID=?";
    private static final String GET_PRICE_FROM_TO_CITY = "SELECT price_direction FROM Directions WHERE from_city=? AND to_city=?";
    private static final String UPDATE_DIRECTION_DATA = "UPDATE Directions SET from_city=?, to_city=?, price_direction=? " +
            "WHERE directionID=?";
    private static final String CREATE_DIRECTION = "INSERT INTO Directions (directionID, from_city, to_city, " +
            "price_direction) VALUES (?, ?, ?, ?)";


    @Override
    public void createDirection(Direction direction) {
        PreparedStatement preparedStatement;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
//        try (Connection connection = SimpleConnection.getInstance().getConnection()) {
            preparedStatement = connection.prepareStatement(CREATE_DIRECTION);
            preparedStatement.setLong(1, direction.getDirectionID());
            preparedStatement.setString(2, direction.getFromCity());
            preparedStatement.setString(3, direction.getToCity());
            preparedStatement.setInt(4, direction.getPriceDirection());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Direction from: " + direction.getFromCity() + " to: " + direction.getToCity() + " was successful created");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }

    }

    @Override
    public List<Direction> getListDirections() {
        List<Direction> directionList = new ArrayList<>();
        Statement statement;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
//        try (Connection connection = SimpleConnection.getInstance().getConnection()) {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_LIST_DIRECTIONS);
            if (resultSet == null){
                LOGGER.error("Your list directions is empty");
            }
            while (resultSet.next()){
                Direction direction = new Direction();
                direction.setFromCity(resultSet.getString("from_city"));
                directionList.add(direction);
            }
//            if (resultSet.next()) {
//                do {
//
//                } while (resultSet.next());
//            } else {
//
//            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return directionList;
    }

    @Override
    public List<Direction> getPriceListDirections() {
        List<Direction> directionList = new ArrayList<>();
        Statement statement;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
//        try (Connection connection = SimpleConnection.getInstance().getConnection()) {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_PRICE_LIST_DIRECTIONS);
            if (resultSet == null){
                LOGGER.error("Your price list directions is empty");
            }
            while (resultSet.next()){
                Direction direction = new Direction();
                direction.setDirectionID(resultSet.getLong("directionID"));
                direction.setFromCity(resultSet.getString("from_city"));
                direction.setToCity(resultSet.getString("to_city"));
                direction.setPriceDirection(resultSet.getInt("price_direction"));
                directionList.add(direction);
            }
//            if (resultSet.next()) {
//                do {
//
//                } while (resultSet.next());
//            } else {
//
//            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return directionList;
    }

    @Override
    public Direction getDirectionByFromCity(String fromCity) {
        Direction direction = new Direction();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_DIRECTION_BY_FROM_CITY)
        ) {
            preparedStatement.setString(1, fromCity);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null){
                LOGGER.info("City " + fromCity + " doesn't have in list");
            }
            while (resultSet.next()){
                direction.setDirectionID(resultSet.getLong("directionID"));
                direction.setFromCity(resultSet.getString("from_city"));
                direction.setToCity(resultSet.getString("to_city"));
                direction.setPriceDirection(resultSet.getInt("price_direction"));
                preparedStatement.executeUpdate();
            }
//            if (resultSet.next()) {
//                do {
//
//                } while (resultSet.next());
//            } else {
//                LOGGER.info("City " + fromCity + " doesn't have in list");
//
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return direction;
    }

    @Override
    public void updateDirection(Direction direction) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DIRECTION_DATA)
        ) {
            preparedStatement.setString(1, direction.getFromCity());
            preparedStatement.setString(2, direction.getToCity());
            preparedStatement.setInt(3, direction.getPriceDirection());
            preparedStatement.setLong(4, direction.getDirectionID());
            connection.commit();
            LOGGER.info("Direction with id:  " + direction.getDirectionID() + " was updated");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }

    @Override
    public Integer getPriceByCity(String from, String to){
        int price = 0;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRICE_FROM_TO_CITY)
        ) {
            preparedStatement.setString(1, from);
            preparedStatement.setString(2, to);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                price = resultSet.getInt(1);
            } else{
                LOGGER.error("Can't find at the table price for city");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }


    @Override
    public void deleteDirectionById(Long id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DIRECTION_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Direction with id: " + id + " was successful deleted");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }
}
