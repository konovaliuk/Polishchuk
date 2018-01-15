package ua.com.delivery.persistence.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.IOrderToWarehouseDao;
import ua.com.delivery.persistence.entity.OrderToWarehouse;
import ua.com.delivery.persistence.utilDao.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderToWarehouseImpl implements IOrderToWarehouseDao {
    private static final Logger LOGGER = Logger.getLogger(OrderToWarehouse.class);
    private static final String GET_ORDER_BY_ID = "SELECT * FROM OrderToWarehouse WHERE ordertowarehouseID=?";
    private static final String GET_LIST_ORDER_TO_WAREHOUSE = "SELECT * FROM OrderToWarehouse";
    private static final String DELETE_ORDER_TO_WAREHOUSE_BY_ID = "DELETE FROM OrderToWarehouse WHERE ordertowarehouseID=?";
    private static final String UPDATE_DATA_ORDER_TO_WAREHOUSE = "UPDATE OrderToWarehouse SET date_of_departure=?," +
            " departure_address=?, city_of_receipt=?, user_name=?, phone=?,  weight=?, number_of_order=?, email=? ,total_price=? " +
            "WHERE ordertowarehouseID=?";
    private static final String CREATE_ORDER_TO_WAREHOUSE = "INSERT INTO OrderToWarehouse (date_of_departure, " +
            "departure_address, city_of_receipt, user_name, phone, weight, email, number_of_order, total_price)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public void createOrderToWarehouse(OrderToWarehouse orderToWarehouse) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER_TO_WAREHOUSE)
        ) {
            preparedStatement.setDate(1, orderToWarehouse.getDateOfDeparture());
            preparedStatement.setString(2, orderToWarehouse.getDepartureAddress());
            preparedStatement.setString(3, orderToWarehouse.getCityOfReceipt());
            preparedStatement.setString(4, orderToWarehouse.getUserName());
            preparedStatement.setInt(5, orderToWarehouse.getPhone());
            preparedStatement.setInt(6, orderToWarehouse.getWeight());
            preparedStatement.setString(7, orderToWarehouse.getEmail());
            preparedStatement.setInt(8, orderToWarehouse.getNumberOfOrder());
            preparedStatement.setInt(9, orderToWarehouse.getTotalPrice());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Order to warehouse was successful created");
        } catch (SQLException e) {
            LOGGER.error("Order to warehouse wasn't created");
            LOGGER.error(e.toString());
        }
    }

    @Override
    public List<OrderToWarehouse> getListOrdersToWarehouse() {
        List<OrderToWarehouse> orderToWarehouseList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_LIST_ORDER_TO_WAREHOUSE)
        ) {
            if (resultSet.next()) {
                do {
                    OrderToWarehouse orderToWarehouse = new OrderToWarehouse();
                    orderToWarehouse.setOrderToWarehouseID(resultSet.getLong("ordertowarehouseID"));
                    orderToWarehouse.setDateOfDeparture(resultSet.getDate("date_of_departure"));
                    orderToWarehouse.setDepartureAddress(resultSet.getString("departure_address"));
                    orderToWarehouse.setCityOfReceipt(resultSet.getString("city_of_receipt"));
                    orderToWarehouse.setUserName(resultSet.getString("user_name"));
                    orderToWarehouse.setPhone(resultSet.getInt("phone"));
                    orderToWarehouse.setWeight(resultSet.getInt("weight"));
                    orderToWarehouse.setNumberOfOrder(resultSet.getInt("number_of_order"));
                    orderToWarehouse.setEmail(resultSet.getString("email"));
                    orderToWarehouse.setTotalPrice(resultSet.getInt("total_price"));
                    orderToWarehouseList.add(orderToWarehouse);
                } while (resultSet.next());
            } else {
                LOGGER.info("List Orders to warehouse is empty.");
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return orderToWarehouseList;
    }

    @Override
    public OrderToWarehouse getById(Long id) {
        OrderToWarehouse orderToWarehouse = new OrderToWarehouse();
                try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    orderToWarehouse.setOrderToWarehouseID(resultSet.getLong("ordertowarehouseID"));
                    orderToWarehouse.setDateOfDeparture(resultSet.getDate("date_of_departure"));
                    orderToWarehouse.setDepartureAddress((resultSet.getString("departure_address")));
                    orderToWarehouse.setCityOfReceipt(resultSet.getString("city_of_receipt"));
                    orderToWarehouse.setUserName(resultSet.getString("user_name"));
                    orderToWarehouse.setPhone(resultSet.getInt("phone"));
                    orderToWarehouse.setWeight(resultSet.getInt("weight"));
                    orderToWarehouse.setNumberOfOrder(resultSet.getInt("number_of_order"));
                    orderToWarehouse.setEmail(resultSet.getString("email"));
                    orderToWarehouse.setTotalPrice(resultSet.getInt("total_price"));
                    preparedStatement.executeUpdate();
                } while (resultSet.next());
            } else {
                LOGGER.info("Order with id: " + id + " doesn't in the list");
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return orderToWarehouse;
    }

    @Override
    public void updateOrderToWarehouse(OrderToWarehouse orderToWarehouse) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DATA_ORDER_TO_WAREHOUSE)
        ) {
            preparedStatement.setDate(1, orderToWarehouse.getDateOfDeparture());
            preparedStatement.setString(2, orderToWarehouse.getDepartureAddress());
            preparedStatement.setString(3, orderToWarehouse.getCityOfReceipt());
            preparedStatement.setString(4, orderToWarehouse.getUserName());
            preparedStatement.setInt(5, orderToWarehouse.getPhone());
            preparedStatement.setInt(6, orderToWarehouse.getWeight());
            preparedStatement.setInt(7, orderToWarehouse.getNumberOfOrder());
            preparedStatement.setString(8, orderToWarehouse.getEmail());
            preparedStatement.setInt(9, orderToWarehouse.getTotalPrice());
            preparedStatement.setLong(10, orderToWarehouse.getOrderToWarehouseID());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Order to warehouse with id:  " + orderToWarehouse.getOrderToWarehouseID() + " was updated");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }

    @Override
    public void deleteOrderToWarehouseById(Long id) {
                try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_TO_WAREHOUSE_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Order to warehouse with id: " + id + " was successful deleted");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }
}
