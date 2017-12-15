package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.OrderFromWarehouse;

import java.util.List;

public interface IOrderFromWarehouseDao {
    //create new orderFormWarehouse
    void createOrderFromWarehouse(OrderFromWarehouse orderFromWarehouse);

    //will return us list all orderFormWarehouses
    List<OrderFromWarehouse> getListOrdersFromWarehouse();

    //will return us one orderFormWarehouse by field
    OrderFromWarehouse getById(Long id);

    //this part will be update our orderFormWarehouse
    void updateOrderFromWarehouse(OrderFromWarehouse orderFromWarehouse);

    //this method will be delete one orderFormWarehouse
    void deleteOrderFromWarehouseById(Long id);
}
