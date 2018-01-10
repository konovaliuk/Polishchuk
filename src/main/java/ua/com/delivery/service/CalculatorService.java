package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;

public class CalculatorService {
    private static final Logger LOGGER = Logger.getLogger(CalculatorService.class);
    private static CalculatorService INSTANCE;
    private static final String USER = "UserDAO";

    private IAbstractFactory factory;

    private CalculatorService(){
        factory = new AbstractFactory();
    }

    public static CalculatorService getInstance(){
        if (INSTANCE == null){
            synchronized (LoginService.class){
                if (INSTANCE == null){
                    INSTANCE = new CalculatorService();
                }
            }
        }
        return INSTANCE;
    }

    public int calculateDelivery(int routePrice,  int weightPrice){
        return routePrice + weightPrice;
    }
}
