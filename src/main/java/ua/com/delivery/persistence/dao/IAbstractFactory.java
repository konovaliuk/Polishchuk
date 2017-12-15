package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.dao.daoimpl.*;

public interface IAbstractFactory {
    AdministratorImpl createAdminDao();
    CalculatorImpl createCalculatorDao();
    CargoPriceImpl createCargoDao();
    DirectionImpl createDirectionDao();
    OrderFromWarehouseImpl createOrderFromWarehouseDao();
    OrderToWarehouseImpl createOrderToWarehouseDao();
    ParcelPriceImpl createParcelPriceDao();
    UserImpl createUserDao();
}
