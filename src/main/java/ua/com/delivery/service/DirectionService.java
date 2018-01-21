package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;
import ua.com.delivery.persistence.entity.Direction;

import java.util.Comparator;
import java.util.List;

public class DirectionService {
    private static final Logger LOGGER = Logger.getLogger(DirectionService.class);
    private static DirectionService INSTANCE;

    private IAbstractFactory factory;

    private DirectionService() {
        factory = new AbstractFactory();
    }

    public static DirectionService getInstance() {
        if (INSTANCE == null) {
            synchronized (DirectionService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DirectionService();
                }
            }
        }
        return INSTANCE;
    }

    public List<Direction> searchFromToCity() {
        List<Direction> directionList = factory.createDirectionDao().getListDirections();
        directionList.sort(Comparator.comparing(Direction::getFromCity));
        LOGGER.info("It's a list from/to city");
        return directionList;
    }

    public Integer countDirectionRecords() {
        return factory.createDirectionDao().countDirectionRecord();
    }

    public List<Direction> getDirectionRecords(int start, int total) {
        return factory.createDirectionDao().getRecords(start, total);
    }

    public Integer priceForCity(String from, String to, int weight) {
        Integer weightPrice = factory.createParcelPriceDao().getByWeight(weight).getWeight();
        Integer cityPrice = factory.createDirectionDao().getPriceByCity(from, to);
        Integer resultPrice;
        if (weightPrice != null) {
            resultPrice = weightPrice + cityPrice;
        } else {
            resultPrice = cityPrice;
        }
        return resultPrice;
    }

    public Integer priceBetweenCity(String from, String to) {
        Integer cityPrice = factory.createDirectionDao().getPriceByCity(from, to);
        if (cityPrice == null) {
            LOGGER.error("Table hasn't include price for this city");
        }
        return cityPrice;
    }

    public Integer priceByWeight(int weight) {
        Integer weightPrice = factory.createParcelPriceDao().getByWeight(weight).getWeight();
        if (weightPrice == null) {
            LOGGER.error("Table hasn't data for this weight: " + weight);
        }
        return weightPrice;
    }
}
