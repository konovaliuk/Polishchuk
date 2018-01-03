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

    private DirectionService(){
        factory = new AbstractFactory();
    }

    public static DirectionService getInstance(){
        if (INSTANCE == null){
            synchronized (DirectionService.class){
                if (INSTANCE == null){
                    INSTANCE = new DirectionService();
                }
            }
        }
        return INSTANCE;
    }

    public List<Direction> searchFromToCity(){
        List<Direction> directionList = factory.createDirectionDao().getListDirections();
        directionList.sort(Comparator.comparing(Direction::getFromCity));
        LOGGER.info("It's a list from/to city");
        return directionList;
    }

    public List<Direction> listForPrice(){
        return factory.createDirectionDao().getListDirections();
    }
}
