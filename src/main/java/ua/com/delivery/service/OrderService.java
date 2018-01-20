package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;

import java.util.Random;

public class OrderService {
    private static final Logger LOGGER = Logger.getLogger(OrderService.class);
    private static OrderService INSTANCE;

    private IAbstractFactory factory;

    private OrderService() {
        factory = new AbstractFactory();
    }

    public static OrderService getInstance() {
        if (INSTANCE == null) {
            synchronized (OrderService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OrderService();
                }
            }
        }
        return INSTANCE;
    }

    public Integer numberOfOrder() {
        Random random = new Random();
        return random.nextInt(666) + 1;
    }

    public Integer totalPriceOfReceipt(int weight) {
        Integer weightPrice = factory.createParcelPriceDao().getByWeight(weight);
        Random random = new Random();
        int cityPrice = random.nextInt(500) + 1;
        return weightPrice + cityPrice;
    }

}
