package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.OrderToWarehouse;

import java.util.List;
/**
 * This interface represents a contract for a DAO for the {@link OrderToWarehouse} model.
 *
 */
public interface IOrderToWarehouseDao {
    //create new orderToWarehouse
    void createOrderToWarehouse(OrderToWarehouse orderToWarehouse);

    //will return us list all orderToWarehouses
    List<OrderToWarehouse> getListOrdersToWarehouse();

    //will return us one orderToWarehouse by field
    OrderToWarehouse getById(Long id);

    //this part will be update our orderToWarehouse
    void updateOrderToWarehouse(OrderToWarehouse orderToWarehouse);

    //this method will be delete one orderFormWarehouse
    void deleteOrderToWarehouseById(Long id);
}
