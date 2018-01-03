package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.dao.daoimpl.*;

public class AbstractFactory implements IAbstractFactory {

    public CalculatorImpl createCalculatorDao() {
        return new CalculatorImpl();
    }

    public CargoPriceImpl createCargoDao(){
        return new CargoPriceImpl();
    }

    public DirectionImpl createDirectionDao() {
        return new DirectionImpl();
    }

    public OrderFromWarehouseImpl createOrderFromWarehouseDao(){
        return new OrderFromWarehouseImpl();
    }

    public OrderToWarehouseImpl createOrderToWarehouseDao(){
        return new OrderToWarehouseImpl();
    }

    public ParcelPriceImpl createParcelPriceDao(){
        return new ParcelPriceImpl();
    }

    public UserImpl createUserDao(){
        return new UserImpl();
    }
}
