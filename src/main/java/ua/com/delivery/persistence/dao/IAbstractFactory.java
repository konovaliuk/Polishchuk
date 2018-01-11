package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.dao.daoimpl.*;

public interface IAbstractFactory {
    CalculatorImpl createCalculatorDao();
    DirectionImpl createDirectionDao();
    OrderFromWarehouseImpl createOrderFromWarehouseDao();
    OrderToWarehouseImpl createOrderToWarehouseDao();
    ParcelPriceImpl createParcelPriceDao();
    UserImpl createUserDao();
}
