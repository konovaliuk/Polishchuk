package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.Direction;

import java.util.List;
/**
 * This interface represents a contract for a DAO for the {@link Direction} model.
 *
 */
public interface IDirectionDao {
    //create new direction(from-to-price)
    void createDirection(Direction direction);

    Integer getPriceByCity(String from, String to);

    //will return us list all directions
    List<Direction> getListDirections();

    List<Direction> getPriceListDirections();

    //will return us one directions by field
    Direction getDirectionByFromCity(String  fromCity);

    //this part will be update our data
    void updateDirection(Direction direction);

    //this method will be delete one direction
    void deleteDirectionById(Long id);

}
