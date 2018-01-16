package ua.com.delivery.persistence.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.IOrderFromWarehouseDao;
import ua.com.delivery.persistence.entity.OrderFromWarehouse;
import ua.com.delivery.persistence.utilDao.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderFromWarehouseImpl implements IOrderFromWarehouseDao {
    private static final Logger LOGGER = Logger.getLogger(OrderFromWarehouseImpl.class);
    private static final String GET_LIST_ORDER_FROM_WAREHOUSE = "SELECT * FROM OrderFromWarehouse";
    private static final String GET_ORDER_BY_ID = "SELECT * FROM OrderFromWarehouse WHERE orderfromwarehouseID=?";
    private static final String DELETE_ORDER_FROM_WAREHOUSE_BY_ID = "DELETE FROM OrderFromWarehouse WHERE orderfromwarehouseID=?";
    private static final String UPDATE_DATA_ORDER_FROM_WAREHOUSE = "UPDATE OrderFromWarehouse SET number_of_order=?," +
            " date_to_delivery=?, city_departure=?, user_name=?, phone=?, address_to_delivery=?, weight=?,  email=?, " +
            "type_of_parcel=?, total_price=? WHERE orderfromwarehouseID=?";
    private static final String CREATE_ORDER_FROM_WAREHOUSE = "INSERT INTO OrderFromWarehouse (number_of_order, " +
            "date_to_delivery, city_departure, user_name, phone, address_to_delivery, weight, email, type_of_parcel,  total_price)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public void createOrderFromWarehouse(OrderFromWarehouse orderFromWarehouse) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try  (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER_FROM_WAREHOUSE)
        ){
//            preparedStatement.setLong(1, orderFromWarehouse.getOrderFromWarehouseID());
            preparedStatement.setInt(1, orderFromWarehouse.getNumberOfOrder());
            preparedStatement.setDate(2, orderFromWarehouse.getDateToDelivery());
            preparedStatement.setString(3, orderFromWarehouse.getCityDeparture());
            preparedStatement.setString(4, orderFromWarehouse.getUserName());
            preparedStatement.setInt(5, orderFromWarehouse.getPhone());
            preparedStatement.setString(6, orderFromWarehouse.getAddressToDelivery());
            preparedStatement.setInt(7, orderFromWarehouse.getWeight());
            preparedStatement.setString(8, orderFromWarehouse.getEmail());
            preparedStatement.setString(9, orderFromWarehouse.getTypeOfParcel());
            preparedStatement.setInt(10, orderFromWarehouse.getTotalPrice());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Order from warehouse was successful created");
        } catch (SQLException e) {
            LOGGER.info("Order from warehouse wasn't created");
            LOGGER.error(e.toString());
        }
    }

    @Override
    public List<OrderFromWarehouse> getListOrdersFromWarehouse() {
        List<OrderFromWarehouse> orderFromWarehouseList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_LIST_ORDER_FROM_WAREHOUSE)
        ) {
            if (resultSet.next()) {
                do {
                    OrderFromWarehouse orderFromWarehouse = new OrderFromWarehouse();
                    orderFromWarehouse.setOrderFromWarehouseID(resultSet.getLong("orderfromwarehouseID"));
                    orderFromWarehouse.setNumberOfOrder(resultSet.getInt("number_of_order"));
                    orderFromWarehouse.setDateToDelivery(resultSet.getDate("date_to_delivery"));
                    orderFromWarehouse.setCityDeparture(resultSet.getString("city_departure"));
                    orderFromWarehouse.setUserName(resultSet.getString("user_name"));
                    orderFromWarehouse.setPhone(resultSet.getInt("phone"));
                    orderFromWarehouse.setAddressToDelivery(resultSet.getString("address_to_delivery"));
                    orderFromWarehouse.setWeight(resultSet.getInt("weight"));
                    orderFromWarehouse.setEmail(resultSet.getString("email"));
                    orderFromWarehouse.setTypeOfParcel(resultSet.getString("type_of_parcel"));
                    orderFromWarehouse.setTotalPrice(resultSet.getInt("total_price"));
                    orderFromWarehouseList.add(orderFromWarehouse);
                } while (resultSet.next());
            } else {
                LOGGER.info("List Orders from warehouse is empty.");
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return orderFromWarehouseList;
    }

    @Override
    public OrderFromWarehouse getById(Long id) {
        OrderFromWarehouse orderFromWarehouse = new OrderFromWarehouse();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID)
        ) {
            //вказую значення id, яке приходить до нас із параметра
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    orderFromWarehouse.setOrderFromWarehouseID(resultSet.getLong("orderfromwarehouseID"));
                    orderFromWarehouse.setNumberOfOrder(resultSet.getInt("number_of_order"));
                    orderFromWarehouse.setDateToDelivery(resultSet.getDate("date_to_delivery"));
                    orderFromWarehouse.setCityDeparture(resultSet.getString("city_departure"));
                    orderFromWarehouse.setUserName(resultSet.getString("user_name"));
                    orderFromWarehouse.setPhone(resultSet.getInt("phone"));
                    orderFromWarehouse.setAddressToDelivery(resultSet.getString("address_to_delivery"));
                    orderFromWarehouse.setWeight(resultSet.getInt("weight"));
                    orderFromWarehouse.setEmail(resultSet.getString("email"));
                    orderFromWarehouse.setTypeOfParcel(resultSet.getString("type_of_parcel"));
                    orderFromWarehouse.setTotalPrice(resultSet.getInt("total_price"));

                    preparedStatement.executeUpdate();
                } while (resultSet.next());
            } else {
                LOGGER.info("Order with id: " + id + " doesn't in the list");
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
        return orderFromWarehouse;
    }

    @Override
    public void updateOrderFromWarehouse(OrderFromWarehouse orderFromWarehouse) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DATA_ORDER_FROM_WAREHOUSE)
        ) {
            preparedStatement.setInt(1, orderFromWarehouse.getNumberOfOrder());
            preparedStatement.setDate(2, orderFromWarehouse.getDateToDelivery());
            preparedStatement.setString(3, orderFromWarehouse.getCityDeparture());
            preparedStatement.setString(4, orderFromWarehouse.getUserName());
            preparedStatement.setInt(5, orderFromWarehouse.getPhone());
            preparedStatement.setString(6, orderFromWarehouse.getAddressToDelivery());
            preparedStatement.setInt(7, orderFromWarehouse.getWeight());
            preparedStatement.setString(8, orderFromWarehouse.getEmail());
            preparedStatement.setString(9, orderFromWarehouse.getTypeOfParcel());
            preparedStatement.setInt(10, orderFromWarehouse.getTotalPrice());
            preparedStatement.setLong(11, orderFromWarehouse.getOrderFromWarehouseID());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Order from warehouse with id:  " + orderFromWarehouse.getOrderFromWarehouseID() + " was updated");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }

    @Override
    public void deleteOrderFromWarehouseById(Long id) {
                try (Connection connection = ConnectionPool.getInstance().getConnection();
//        try (Connection connection = SimpleConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_FROM_WAREHOUSE_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Order from warehouse with id: " + id + " was successful deleted");
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        }
    }
}
