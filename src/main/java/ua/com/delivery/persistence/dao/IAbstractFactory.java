package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.dao.daoimpl.*;

public interface IAbstractFactory {

    /**
     * Interface for creating instances of dao implementations
     */
    DirectionImpl createDirectionDao();

    OrderFromWarehouseImpl createOrderFromWarehouseDao();

    OrderToWarehouseImpl createOrderToWarehouseDao();

    ParcelPriceImpl createParcelPriceDao();

    UserImpl createUserDao();
}
