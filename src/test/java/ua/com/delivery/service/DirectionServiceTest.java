package ua.com.delivery.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.daoimpl.DirectionImpl;
import ua.com.delivery.persistence.dao.daoimpl.ParcelPriceImpl;
import ua.com.delivery.persistence.entity.Direction;
import ua.com.delivery.persistence.entity.ParcelPrice;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DirectionServiceTest {


    @Mock
    private AbstractFactory factory;

    @Mock
    private ParcelPrice parcelPrice;

    @Mock
    private Direction direction;

    @Mock
    private ParcelPriceImpl parcelPriceDao;

    @Mock
    private DirectionImpl directionDao;

    @Mock
    private DirectionService directionService;

    @Before
    public void setUp(){
        parcelPrice = new ParcelPrice();
        parcelPrice.setPrice(15);
        parcelPrice.setWeight(3);

        direction = new Direction();
        direction.setFromCity("Kiev");
        direction.setToCity("Lviv");
        direction.setPriceDirection(250);

        when(parcelPriceDao.getByWeight(parcelPrice.getWeight())).thenReturn(parcelPrice);
        when(factory.createParcelPriceDao()).thenReturn(parcelPriceDao);
        when(directionDao.getPriceByCity(direction.getFromCity(), direction.getToCity())).thenReturn(250);
        when(factory.createDirectionDao()).thenReturn(directionDao);
    }

    @Test
    public void testPriceForCity(){
//        int testWeightPrice = directionService.priceForCity(direction.getFromCity(), direction.getToCity(), direction.getPriceDirection());
//        assertEquals(parcelPrice.getPrice(), testWeightPrice);
    }

}
