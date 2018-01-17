package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.dao.daoimpl.*;

public interface IAbstractFactory {
    DirectionImpl createDirectionDao();
    OrderFromWarehouseImpl createOrderFromWarehouseDao();
    OrderToWarehouseImpl createOrderToWarehouseDao();
    ParcelPriceImpl createParcelPriceDao();
    UserImpl createUserDao();
}
