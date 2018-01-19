package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.ParcelPrice;

import java.util.List;

/**
 * This interface represents a contract for a DAO for the {@link ParcelPrice} model.
 */
public interface IParcelPriceDao {
    //create new parcelPrice
    void createParcelPrice(ParcelPrice parcelPrice);

    //will return us list all parcelPrice
    List<ParcelPrice> getListParcelPrices();

    //will return us one parcelPrice by field
    Integer getByWeight(int weight);

    //this part will be update our parcelPrice
    void updateParcelPrice(ParcelPrice parcelPrice);

    //this method will be delete one parcelPrice
    void deleteParcelPriceByWeight(Integer weight);
}
