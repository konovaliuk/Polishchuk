package ua.com.delivery.persistence.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.IParcelPriceDao;
import ua.com.delivery.persistence.entity.ParcelPrice;
import ua.com.delivery.persistence.util.SimpleConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParcelPriceImpl implements IParcelPriceDao{
    private static final Logger LOGGER = Logger.getLogger(ParcelPriceImpl.class);
    private static final String GET_LIST_PARCEL_PRICE = "SELECT * FROM ParcelPrice";
    private static final String GET_PARCEL_PRICE_BY_ID = "SELECT * FROM ParcelPrice WHERE parcelpriceID=?";
    private static final String DELETE_PARCEL_PRICE_BY_WEIGHT = "DELETE FROM ParcelPrice WHERE weight=?";
    private static final String UPDATE_PARCEL_PRICE_DATA = "UPDATE ParcelPrice SET weight=?, price=? WHERE parcelpriceID=?";
    private static final String CREATE_PARCEL_PRICE = "INSERT INTO ParcelPrice (parcelpriceID, weight, price) " +
            "VALUES (?, ?, ?)";

    @Override
    public void createParcelPrice(ParcelPrice parcelPrice) {
        //        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PARCEL_PRICE)
        ) {
            preparedStatement.setLong(1, parcelPrice.getParcelpriceID());
            preparedStatement.setInt(2, parcelPrice.getWeight());
            preparedStatement.setInt(3, parcelPrice.getPrice());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Parcel price was created");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }

    @Override
    public List<ParcelPrice> getListParcelPrices() {
        List<ParcelPrice> parcelPriceList = new ArrayList<>();
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_LIST_PARCEL_PRICE)
        ) {
            if (resultSet.next()) {
                do {

                    ParcelPrice parcelPrice = new ParcelPrice();
                    parcelPrice.setParcelpriceID(resultSet.getLong("parcelpriceID"));
                    parcelPrice.setWeight(resultSet.getInt("weight"));
                    parcelPrice.setPrice(resultSet.getInt("price"));
                    parcelPriceList.add(parcelPrice);
                } while (resultSet.next());
            } else {
                LOGGER.info("Parcel price list doesn't have next element");
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return parcelPriceList;
    }

    @Override
    public ParcelPrice getById(Long id) {
        ParcelPrice parcelPrice = new ParcelPrice();
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PARCEL_PRICE_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    parcelPrice.setParcelpriceID(resultSet.getLong("parcelpriceID"));
                    parcelPrice.setWeight(resultSet.getInt("weight"));
                    parcelPrice.setPrice(resultSet.getInt("volume"));
                    preparedStatement.executeUpdate();
                } while (resultSet.next());
            } else {
                LOGGER.info("No ParcelPrice with id: " + id);
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return parcelPrice;
    }

    @Override
    public void updateParcelPrice(ParcelPrice parcelPrice) {
        //        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PARCEL_PRICE_DATA)
        ) {
            preparedStatement.setInt(1, parcelPrice.getWeight());
            preparedStatement.setInt(2, parcelPrice.getPrice());
            preparedStatement.setLong(3, parcelPrice.getParcelpriceID());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Updating parcel price was successful");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }

    @Override
    public void deleteParcelPriceByWeight(Integer weight) {
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PARCEL_PRICE_BY_WEIGHT)
        ) {
            preparedStatement.setInt(1, weight);
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Parcel price with weight: " + weight + " was successful deleted.");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }
}
