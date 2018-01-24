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
    private static final String GET_LIST_RECORDS = "SELECT * FROM Directions LIMIT ?,?";
    private static final String GET_DIRECTION_BY_FROM_CITY = "SELECT * FROM Directions WHERE from_city=?";
    private static final String DELETE_DIRECTION_BY_ID = "DELETE FROM Directions WHERE directionID=?";
    private static final String GET_COUNT_RECORD = "SELECT COUNT(*) FROM Directions";
    private static final String GET_PRICE_FROM_TO_CITY = "SELECT price_direction FROM Directions WHERE from_city=? AND to_city=?";
    private static final String UPDATE_DIRECTION_DATA = "UPDATE Directions SET from_city=?, to_city=?, price_direction=? " +
            "WHERE directionID=?";
    private static final String CREATE_DIRECTION = "INSERT INTO Directions (directionID, from_city, to_city, " +
            "price_direction) VALUES (?, ?, ?, ?)";



    /**
     * Create direction  in database
     *
     * @param direction instance of entity {@code Direction}
     */
    @Override
    public void createDirection(Direction direction) {
        PreparedStatement preparedStatement;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            preparedStatement = connection.prepareStatement(CREATE_DIRECTION);
            preparedStatement.setLong(1, direction.getDirectionID());
            preparedStatement.setString(2, direction.getFromCity());
            preparedStatement.setString(3, direction.getToCity());
            preparedStatement.setInt(4, direction.getPriceDirection());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Direction from: " + direction.getFromCity() + " to: " + direction.getToCity() + " was successful created");
        } catch (SQLException e) {
            LOGGER.error("Problem in DirectionImpl, in method createDirection");
        }

    }

    /**
     * Method for getting list of directions from database
     *
     * @return direction List
     */
    @Override
    public List<Direction> getListDirections() {
        List<Direction> directionList = new ArrayList<>();
        Statement statement;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_LIST_DIRECTIONS);
            if (resultSet == null) {
                LOGGER.error("Your list directions is empty");
            }
            while (resultSet.next()) {
                Direction direction = new Direction();
                direction.setFromCity(resultSet.getString("from_city"));
                directionList.add(direction);
            }
        } catch (SQLException e) {
            LOGGER.error("Problem in DirectionImpl, in method getListDirections");
        }
        return directionList;
    }

    /**
     * Method for getting list of records with two parameters
     *
     * @param start
     * @param total
     * @return directionList
     */
    @Override
    public List<Direction> getRecords(int start, int total) {
        List<Direction> directionList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_RECORDS)
        ) {
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, total);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                LOGGER.error("Your list directions for get records is empty");
            }

            while (resultSet.next()) {
                Direction direction = new Direction();
                direction.setDirectionID(resultSet.getLong("directionID"));
                direction.setFromCity(resultSet.getString("from_city"));
                direction.setToCity(resultSet.getString("to_city"));
                direction.setPriceDirection(resultSet.getInt("price_direction"));
                directionList.add(direction);
            }
        } catch (SQLException e) {
            LOGGER.error("Problem in DirectionImpl, in method getRecords");
        }
        return directionList;
    }

    /**
     * Method for getting direction by from_city  of records with parameter
     *
     * @param fromCity
     * @return direction
     */
    @Override
    public Direction getDirectionByFromCity(String fromCity) {
        Direction direction = new Direction();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_DIRECTION_BY_FROM_CITY)
        ) {
            preparedStatement.setString(1, fromCity);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                LOGGER.info("City " + fromCity + " doesn't have in list");
            }
            if (resultSet.next()) {
                direction.setDirectionID(resultSet.getLong("directionID"));
                direction.setFromCity(resultSet.getString("from_city"));
                direction.setToCity(resultSet.getString("to_city"));
                direction.setPriceDirection(resultSet.getInt("price_direction"));
                preparedStatement.executeQuery();
            } else {
                LOGGER.info("No city from this place: " + fromCity);
            }
        } catch (SQLException e) {
            LOGGER.error("Problem in DirectionImpl, in method getDirectionByFromCity");
        }
        return direction;
    }

    /**
     * Method for update direction in database
     *
     * @param direction
     */
    @Override
    public void updateDirection(Direction direction) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DIRECTION_DATA)
        ) {
            preparedStatement.setString(1, direction.getFromCity());
            preparedStatement.setString(2, direction.getToCity());
            preparedStatement.setInt(3, direction.getPriceDirection());
            preparedStatement.setLong(4, direction.getDirectionID());
            connection.commit();
            LOGGER.info("Direction with id:  " + direction.getDirectionID() + " was updated");
        } catch (SQLException e) {
            LOGGER.error("Problem in DirectionImpl, in method updateDirection");
        }
    }

    /**
     * Method counts the number of records in Direction table in database
     *
     * @return count
     */
    @Override
    public Integer countDirectionRecord() {
        int count = 0;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_COUNT_RECORD)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            } else {
                LOGGER.error("The table doesn't have record");
                return null;
            }
        } catch (SQLException e) {
            LOGGER.error("Problem in DirectionImpl, in method countDirectionRecord");
        }
        return count;
    }


    /**
     * Method for getting price between city in Direction table in database
     *
     * @param from
     * @param to
     * @return price
     */
    @Override
    public Integer getPriceByCity(String from, String to) {
        int price = 0;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRICE_FROM_TO_CITY)
        ) {
            preparedStatement.setString(1, from);
            preparedStatement.setString(2, to);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                price = resultSet.getInt(1);
            } else {
                LOGGER.error("Can't find at the table price for city");
                return null;
            }
        } catch (SQLException e) {
            LOGGER.error("Problem in DirectionImpl, in method countDirectionRecord");
        }
        return price;
    }


    /**
     * Method for deleting direction by id in database
     *
     * @param id
     */
    @Override
    public void deleteDirectionById(Long id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DIRECTION_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Direction with id: " + id + " was successful deleted");
        } catch (SQLException e) {
            LOGGER.error("Problem in DirectionImpl, in method deleteDirectionById");
        }
    }
}
