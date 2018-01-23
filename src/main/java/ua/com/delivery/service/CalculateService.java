package ua.com.delivery.service;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CalculateService {
    private static final Logger LOGGER = Logger.getLogger(CalculateService.class);
    private static CalculateService INSTANCE;

    /**
     * Singleton
     *
     * @return INSTANCE
     */
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

    /**
     * Method for calculating price between city
     * with weight from user
     */
    public void calculatePrice(HttpServletRequest request, String fromCity, String toCity, int weight, int declaredPrice) {
        Integer price = DirectionService.getInstance().priceForCity(fromCity, toCity, weight);
        Integer priceByWeight = DirectionService.getInstance().priceByWeight(weight);
        Integer priceBetweenCity = DirectionService.getInstance().priceBetweenCity(fromCity, toCity);
        request.setAttribute("priceFromToCity", price);
        request.setAttribute("priceByWeight", priceByWeight);
        request.setAttribute("priceBetweenCity", priceBetweenCity);
        request.setAttribute("declaredPrice", declaredPrice);
    }
}
