package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.Direction;

import java.util.List;

public interface IDirectionDao {
    //create new direction(from-to-price)
    void createDirection(Direction direction);

    //will return us list all directions
    List<Direction> getListDirections();

    //will return us one directions by field
    Direction getById(Long id);

    //this part will be update our data
    void updateDirection(Direction direction);

    //this method will be delete one direction
    void deleteDirection(Direction direction);

}
