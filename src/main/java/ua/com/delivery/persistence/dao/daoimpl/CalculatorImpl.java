package ua.com.delivery.persistence.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.ICalculatorDao;
import ua.com.delivery.persistence.entity.Calculator;
import ua.com.delivery.persistence.util.SimpleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalculatorImpl implements ICalculatorDao {
    private static final Logger LOGGER = Logger.getLogger(CalculatorImpl.class);
    private static final String CREATE_CALCULATOR = "INSERT INTO Calculator (calculatorID, directionID, cargoID, " +
            "parcelID, date_to_delivery, declared_price, weight, volume) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    @Override
    public void createCalculator(Calculator calculator) {
//        try (Connection connection = ConnectionPool.getInstance().getConnection()){
        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CALCULATOR)
        ){
            preparedStatement.setLong(1, calculator.getCalculatorID());
            preparedStatement.setLong(2, calculator.getDirectionID());
            preparedStatement.setLong(3, calculator.getCargoID());
            preparedStatement.setLong(4, calculator.getParcelID());
            preparedStatement.setDate(5, calculator.getDateToDelivery());
            preparedStatement.setInt(6, calculator.getDeclaredPrice());
            preparedStatement.setInt(7, calculator.getWeight());
            preparedStatement.setInt(8, calculator.getVolume());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Calculator was created");
        } catch (SQLException e){
            LOGGER.error(e.toString());
        }
    }
}
