package ua.com.delivery.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculateServiceTest {

    @Mock
    private DirectionService directionService;

    @Mock
    private CalculateService calculateService;


    private Integer price;
    private Integer priceByWeight;
    private Integer priceBetweenCity;


    @Before
    public void setUp(){
        when(directionService.priceForCity(anyString(), anyString(), anyInt())).thenReturn(100);
        when(directionService.priceByWeight(anyInt())).thenReturn(66);
        when(directionService.priceBetweenCity(anyString(), anyString())).thenReturn(88);
        doAnswer(invocationOnMock ->{
            price = directionService.priceForCity("", "", 0);
            priceByWeight = directionService.priceByWeight(0);
            priceBetweenCity = directionService.priceBetweenCity("", "");
            return null;
        }).when(calculateService).calculatePrice(any(), anyString(), anyString(), anyInt(), anyInt());
    }


    @Test
    public void testCalculatePrice(){
        calculateService.calculatePrice(null, "", "", 0, 0);
        int i = price.intValue();
        assertEquals(i, 100);

    }


}
