package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;

public class OrderService {
    private static final Logger LOGGER = Logger.getLogger(OrderService.class);
    private static OrderService INSTANCE;
    private static final String orderFromWarehouse = "OrderFromWarehouseDao";
    private static final String orderToWarehouse = "OrderToWarehouseDao";

    private IAbstractFactory factory;

    public OrderService() {
        factory = new AbstractFactory();
    }

    public static OrderService getInstance(){
        if (INSTANCE == null){
            synchronized (OrderService.class){
                if (INSTANCE == null){
                    INSTANCE = new OrderService();
                }
            }
        }
        return INSTANCE;
    }


}
