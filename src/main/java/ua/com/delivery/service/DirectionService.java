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

    /**
     * Singleton
     *
     * @return INSTANCE
     */
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

    /**
     * Method give us list of all city in database
     *
     * @return directionList
     */
    public List<Direction> searchFromToCity() {
        List<Direction> directionList = factory.createDirectionDao().getListDirections();
        directionList.sort(Comparator.comparing(Direction::getFromCity));
        LOGGER.info("It's a list from/to city");
        return directionList;
    }

    /**
     * Method give us counts records of directions
     *
     * @return count of records
     */
    public Integer countDirectionRecords() {
        LOGGER.info("You are successful getting counts of records");
        return factory.createDirectionDao().countDirectionRecord();
    }

    /**
     * Method give us counts records of directions with two param
     *
     * @param start
     * @param total
     * @return count of records
     */
    public List<Direction> getDirectionRecords(int start, int total) {
        LOGGER.info("You are successful getting counts of records with two param (start, total)");
        return factory.createDirectionDao().getRecords(start, total);
    }

    /**
     * Method give us price between city and
     * for total price adding a price by weight
     *
     * @param from
     * @param to
     * @param weight
     * @return resultPrice
     */
    public Integer priceForCity(String from, String to, int weight) {
        Integer weightPrice = factory.createParcelPriceDao().getByWeight(weight).getWeight();
        Integer cityPrice = factory.createDirectionDao().getPriceByCity(from, to);
        Integer resultPrice;
        if (weightPrice != null) {
            LOGGER.info("You are successful get weightPrice and cityPrice");
            resultPrice = weightPrice + cityPrice;
        } else {
            LOGGER.info("You are successful get cityPrice");
            resultPrice = cityPrice;
        }
        return resultPrice;
    }

    /**
     * Method give us price between city
     *
     * @param from
     * @param to
     * @return cityPrice
     */
    public Integer priceBetweenCity(String from, String to) {
        Integer cityPrice = factory.createDirectionDao().getPriceByCity(from, to);
        if (cityPrice == null) {
            LOGGER.error("Table hasn't include price for this city");
        }
        LOGGER.info("You are successful get a price between city");
        return cityPrice;
    }

    /**
     * Method give us price by weight
     *
     * @param weight
     * @return weightPrice
     */
    public Integer priceByWeight(int weight) {
        Integer weightPrice = factory.createParcelPriceDao().getByWeight(weight).getWeight();
        if (weightPrice == null) {
            LOGGER.error("Table hasn't data for this weight: " + weight);
        }
        LOGGER.info("You are successful get a price by weight");
        return weightPrice;
    }
}
