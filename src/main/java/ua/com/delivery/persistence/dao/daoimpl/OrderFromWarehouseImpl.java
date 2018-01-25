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
    private static final String GET_ORDER_BY_ID = "SELECT * FROM OrderFromWarehouse WHERE order_from_warehouseID=?";
    private static final String DELETE_ORDER_FROM_WAREHOUSE_BY_ID = "DELETE FROM OrderFromWarehouse WHERE order_from_warehouseID=?";
    private static final String UPDATE_DATA_ORDER_FROM_WAREHOUSE = "UPDATE OrderFromWarehouse SET number_of_order=?," +
            " date_to_delivery=?, city_departure=?, user_name=?, phone=?, address_to_delivery=?, weight=?,  email=?, " +
            "type_of_parcel=?, total_price=?, user_id=?, direction_id=?, parcel_price_id=? WHERE order_from_warehouseID=?";
    private static final String CREATE_ORDER_FROM_WAREHOUSE = "INSERT INTO OrderFromWarehouse (number_of_order, " +
            "date_to_delivery, city_departure, user_name, phone, address_to_delivery, weight, email, " +
            "type_of_parcel,  total_price, user_id, direction_id, parcel_price_id)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /**
     * Method create order from warehouse to address of delivery in database
     *
     * @param orderFromWarehouse
     */
    @Override
    public void createOrderFromWarehouse(OrderFromWarehouse orderFromWarehouse) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER_FROM_WAREHOUSE)
        ) {
            preparedStatement.setInt(1, orderFromWarehouse.getNumberOfOrder());
            preparedStatement.setDate(2, orderFromWarehouse.getDateToDelivery());
            preparedStatement.setString(3, orderFromWarehouse.getCityDeparture());
            preparedStatement.setString(4, orderFromWarehouse.getUserName());
            preparedStatement.setString(5, orderFromWarehouse.getPhone());
            preparedStatement.setString(6, orderFromWarehouse.getAddressToDelivery());
            preparedStatement.setInt(7, orderFromWarehouse.getWeight());
            preparedStatement.setString(8, orderFromWarehouse.getEmail());
            preparedStatement.setString(9, orderFromWarehouse.getTypeOfParcel());
            preparedStatement.setInt(10, orderFromWarehouse.getTotalPrice());
            preparedStatement.setLong(11, orderFromWarehouse.getUserId());
            preparedStatement.setLong(12, orderFromWarehouse.getDirectionId());
            preparedStatement.setLong(13, orderFromWarehouse.getParcelPriceId());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Order from warehouse was successful created");
        } catch (SQLException e) {
            LOGGER.info("Order from warehouse wasn't created");
        }
    }

    /**
     * Method for getting list orders from warehouse in database
     *
     * @return orderFromWarehouseList
     */
    @Override
    public List<OrderFromWarehouse> getListOrdersFromWarehouse() {
        List<OrderFromWarehouse> orderFromWarehouseList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_LIST_ORDER_FROM_WAREHOUSE)
        ) {
            if (resultSet.next()) {
                do {
                    OrderFromWarehouse orderFromWarehouse = new OrderFromWarehouse();
                    orderFromWarehouse.setOrderFromWarehouseID(resultSet.getLong("order_from_warehouseID"));
                    orderFromWarehouse.setNumberOfOrder(resultSet.getInt("number_of_order"));
                    orderFromWarehouse.setDateToDelivery(resultSet.getDate("date_to_delivery"));
                    orderFromWarehouse.setCityDeparture(resultSet.getString("city_departure"));
                    orderFromWarehouse.setUserName(resultSet.getString("user_name"));
                    orderFromWarehouse.setPhone(resultSet.getString("phone"));
                    orderFromWarehouse.setAddressToDelivery(resultSet.getString("address_to_delivery"));
                    orderFromWarehouse.setWeight(resultSet.getInt("weight"));
                    orderFromWarehouse.setEmail(resultSet.getString("email"));
                    orderFromWarehouse.setTypeOfParcel(resultSet.getString("type_of_parcel"));
                    orderFromWarehouse.setTotalPrice(resultSet.getInt("total_price"));
                    orderFromWarehouse.setUserId(resultSet.getLong("user_id"));
                    orderFromWarehouse.setUserId(resultSet.getLong("direction_id"));
                    orderFromWarehouse.setUserId(resultSet.getLong("parcel_price_id"));
                    orderFromWarehouseList.add(orderFromWarehouse);
                } while (resultSet.next());
            } else {
                LOGGER.info("List Orders from warehouse is empty.");
            }
        } catch (SQLException e) {
            LOGGER.error("Problem in OrderFromWarehouseImpl, in method getListOrdersFromWarehouse");
        }
        return orderFromWarehouseList;
    }

    /**
     * Method for getting order from warehouse by id
     *
     * @param id
     * @return orderFromWarehouse
     */
    @Override
    public OrderFromWarehouse getById(Long id) {
        OrderFromWarehouse orderFromWarehouse = new OrderFromWarehouse();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID)
        ) {
            //вказую значення id, яке приходить до нас із параметра
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    orderFromWarehouse.setOrderFromWarehouseID(resultSet.getLong("order_from_warehouseID"));
                    orderFromWarehouse.setNumberOfOrder(resultSet.getInt("number_of_order"));
                    orderFromWarehouse.setDateToDelivery(resultSet.getDate("date_to_delivery"));
                    orderFromWarehouse.setCityDeparture(resultSet.getString("city_departure"));
                    orderFromWarehouse.setUserName(resultSet.getString("user_name"));
                    orderFromWarehouse.setPhone(resultSet.getString("phone"));
                    orderFromWarehouse.setAddressToDelivery(resultSet.getString("address_to_delivery"));
                    orderFromWarehouse.setWeight(resultSet.getInt("weight"));
                    orderFromWarehouse.setEmail(resultSet.getString("email"));
                    orderFromWarehouse.setTypeOfParcel(resultSet.getString("type_of_parcel"));
                    orderFromWarehouse.setTotalPrice(resultSet.getInt("total_price"));
                    orderFromWarehouse.setUserId(resultSet.getLong("user_id"));
                    orderFromWarehouse.setDirectionId(resultSet.getLong("direction_id"));
                    orderFromWarehouse.setParcelPriceId(resultSet.getLong("parcel_price_id"));

                    preparedStatement.executeUpdate();
                } while (resultSet.next());
            } else {
                LOGGER.info("Order with id: " + id + " doesn't in the list");
            }
        } catch (SQLException e) {
            LOGGER.error("Problem in OrderFromWarehouseImpl, in method getById");
        }
        return orderFromWarehouse;
    }

    /**
     * Method for updating order from warehouse
     *
     * @param orderFromWarehouse
     */
    @Override
    public void updateOrderFromWarehouse(OrderFromWarehouse orderFromWarehouse) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DATA_ORDER_FROM_WAREHOUSE)
        ) {
            preparedStatement.setInt(1, orderFromWarehouse.getNumberOfOrder());
            preparedStatement.setDate(2, orderFromWarehouse.getDateToDelivery());
            preparedStatement.setString(3, orderFromWarehouse.getCityDeparture());
            preparedStatement.setString(4, orderFromWarehouse.getUserName());
            preparedStatement.setString(5, orderFromWarehouse.getPhone());
            preparedStatement.setString(6, orderFromWarehouse.getAddressToDelivery());
            preparedStatement.setInt(7, orderFromWarehouse.getWeight());
            preparedStatement.setString(8, orderFromWarehouse.getEmail());
            preparedStatement.setString(9, orderFromWarehouse.getTypeOfParcel());
            preparedStatement.setInt(10, orderFromWarehouse.getTotalPrice());
            preparedStatement.setLong(11, orderFromWarehouse.getOrderFromWarehouseID());
            preparedStatement.setLong(12, orderFromWarehouse.getUserId());
            preparedStatement.setLong(13, orderFromWarehouse.getDirectionId());
            preparedStatement.setLong(14, orderFromWarehouse.getParcelPriceId());
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Order from warehouse with id:  " + orderFromWarehouse.getOrderFromWarehouseID() + " was updated");
        } catch (SQLException e) {
            LOGGER.error("Problem in OrderFromWarehouseImpl, in method updateOrderFromWarehouse");
        }
    }

    /**
     * Method for deleting order from warehouese by id
     *
     * @param id
     */
    @Override
    public void deleteOrderFromWarehouseById(Long id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_FROM_WAREHOUSE_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
            LOGGER.info("Order from warehouse with id: " + id + " was successful deleted");
        } catch (SQLException e) {
            LOGGER.error("Problem in OrderFromWarehouseImpl, in method deleteOrderFromWarehouseById");
        }
    }
}
