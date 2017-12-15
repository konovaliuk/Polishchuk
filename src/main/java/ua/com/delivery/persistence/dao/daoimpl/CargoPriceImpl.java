package ua.com.delivery.persistence.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.ICargoPriceDao;
import ua.com.delivery.persistence.entity.CargoPrice;
import ua.com.delivery.persistence.util.SimpleConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargoPriceImpl implements ICargoPriceDao {
    private static final Logger LOGGER = Logger.getLogger(CargoPriceImpl.class);
    private static final String GET_LIST_CARGO_PRICE = "SELECT * FROM CargoPrice";
    private static final String GET_CARGO_PRICE_BY_ID = "SELECT * FROM CargoPrice WHERE cargopriceID=?";
    private static final String DELETE_CARGO_PRICE_BY_WEIGHT = "DELETE FROM CargoPrice WHERE weight=?";
    private static final String UPDATE_CARGO_PRICE_DATA = "UPDATE CargoPrice SET weight=?, price=? WHERE cargopriceID=?";
    private static final String CREATE_CARGO_PRICE = "INSERT INTO CargoPrice (cargopriceID, weight, price) " +
            "VALUES (?, ?, ?)";

    @Override
    public void createCargoPrice(CargoPrice cargoPrice) {
        //        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CARGO_PRICE)
        ) {
            preparedStatement.setLong(1, cargoPrice.getCargopriceID());
            preparedStatement.setInt(2, cargoPrice.getWeight());
            preparedStatement.setInt(3, cargoPrice.getPrice());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Cargo price was created");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }

    @Override
    public List<CargoPrice> getListCargoPrices() {
        List<CargoPrice> cargoPriceList = new ArrayList<>();
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_LIST_CARGO_PRICE)
        ) {
            if (resultSet.next()) {
                do {
                    CargoPrice cargoPrice = new CargoPrice();
                    cargoPrice.setCargopriceID(resultSet.getLong("cargopriceID"));
                    cargoPrice.setWeight(resultSet.getInt("weight"));
                    cargoPrice.setPrice(resultSet.getInt("price"));
                    cargoPriceList.add(cargoPrice);
                } while (resultSet.next());
            } else {
                LOGGER.info("ResultSet doesn't have next element");
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return cargoPriceList;
    }

    @Override
    public CargoPrice getById(Long id) {
        CargoPrice cargoPrice = new CargoPrice();
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CARGO_PRICE_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    cargoPrice.setCargopriceID(resultSet.getLong("cargopriceID"));
                    cargoPrice.setWeight(resultSet.getInt("weight"));
                    cargoPrice.setPrice(resultSet.getInt("volume"));
                    preparedStatement.executeUpdate();
                } while (resultSet.next());
            } else {
                LOGGER.info("No CargoPrice with id: " + id);
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return cargoPrice;
    }

    @Override
    public void updateCargoPrice(CargoPrice cargoPrice) {
        //        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CARGO_PRICE_DATA)
        ) {
            preparedStatement.setInt(1, cargoPrice.getWeight());
            preparedStatement.setInt(2, cargoPrice.getPrice());
            preparedStatement.setLong(3, cargoPrice.getCargopriceID());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Updating cargo price was successful");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }

    @Override
    public void deleteCargoPriceByWeight(int weight) {
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CARGO_PRICE_BY_WEIGHT)
        ) {
            preparedStatement.setInt(1, weight);
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Cargo price with weight: " + weight + " was successful deleted.");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }
}
