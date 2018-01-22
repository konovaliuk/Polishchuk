package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;

import javax.servlet.http.HttpServletRequest;

public class CalculateService {
    private static final Logger LOGGER = Logger.getLogger(CalculateService.class);
    private static CalculateService  INSTANCE;

    private IAbstractFactory factory;

    private CalculateService() {
        factory = new AbstractFactory();
    }

    public static CalculateService getInstance() {
        if (INSTANCE == null) {
            synchronized (CalculateService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CalculateService();
                }
            }
        }
        return INSTANCE;
    }

    public void calculatePrice(HttpServletRequest request, String fromCity, String toCity, int weight) {
        Integer price = DirectionService.getInstance().priceForCity(fromCity, toCity, weight);
        Integer priceByWeight = DirectionService.getInstance().priceByWeight(weight);
        Integer priceBetweenCity = DirectionService.getInstance().priceBetweenCity(fromCity, toCity);
        request.setAttribute("priceFromToCity", price);
        request.setAttribute("priceByWeight", priceByWeight);
        request.setAttribute("priceBetweenCity", priceBetweenCity);
    }
}
