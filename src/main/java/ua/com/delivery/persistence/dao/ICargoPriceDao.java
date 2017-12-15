package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.CargoPrice;

import java.util.List;

public interface ICargoPriceDao {
    //create new CargoPrice
    void createCargoPrice(CargoPrice cargoPrice);

    //will return us list all CargoPrice
    List<CargoPrice> getListCargoPrices();

    //will return us one CargoPrice by field
    CargoPrice getById(Long id);

    //this part will be update our CargoPrice
    void updateCargoPrice(CargoPrice cargoPrice);

    //this method will be delete one CargoPrice
    void deleteCargoPriceByWeight(CargoPrice cargoPrice);
}
