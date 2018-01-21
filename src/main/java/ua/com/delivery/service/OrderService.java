package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.*;
import ua.com.delivery.persistence.dao.daoimpl.OrderFromWarehouseImpl;
import ua.com.delivery.persistence.entity.OrderFromWarehouse;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Random;

public class OrderService {
    private static final Logger LOGGER = Logger.getLogger(OrderService.class);
    private static OrderService INSTANCE;

    private IAbstractFactory factory;

    private OrderService() {
        factory = new AbstractFactory();
    }

    public static OrderService getInstance() {
        if (INSTANCE == null) {
            synchronized (OrderService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OrderService();
                }
            }
        }
        return INSTANCE;
    }

    public void createOrderFrom (HttpServletRequest request, int numberOfOrder, Date dateOfReceipt,
                                 String cityDeparture, String userName, int phone, String addressToDelivery,
                                 int weightOfParcel, String email, int totalPrice, String typeOfParcel){

        IUserDao userDao = new  AbstractFactory().createUserDao();
        IDirectionDao directionDao = new AbstractFactory().createDirectionDao();
        IParcelPriceDao parcelPriceDao = new AbstractFactory().createParcelPriceDao();
        OrderFromWarehouseImpl orderFromWarehouseImpl = new AbstractFactory().createOrderFromWarehouseDao();
        OrderFromWarehouse orderFromWarehouse = new OrderFromWarehouse();
        orderFromWarehouse.setNumberOfOrder(numberOfOrder);
        orderFromWarehouse.setDateToDelivery(dateOfReceipt);
        orderFromWarehouse.setCityDeparture(cityDeparture);
        orderFromWarehouse.setUserName(userName);
        orderFromWarehouse.setPhone(phone);
        orderFromWarehouse.setAddressToDelivery(addressToDelivery);
        orderFromWarehouse.setWeight(weightOfParcel);
        orderFromWarehouse.setEmail(email);
        orderFromWarehouse.setTotalPrice(totalPrice);
        orderFromWarehouse.setTypeOfParcel(typeOfParcel);
        orderFromWarehouse.setUserId(userDao.getUserByUsername((String) request.getSession().getAttribute("visibleUser")).getUserID());
        orderFromWarehouse.setDirectionId(directionDao.getDirectionByFromCity(cityDeparture).getDirectionID());
        orderFromWarehouse.setParcelPriceId(parcelPriceDao.getByWeight(weightOfParcel).getParcelpriceID());
        orderFromWarehouseImpl.createOrderFromWarehouse(orderFromWarehouse);
        request.setAttribute("totalPriceOfReceipt", totalPrice);
    }

    public Integer numberOfOrder() {
        Random random = new Random();
        return random.nextInt(666) + 1;
    }

    public Integer totalPriceOfReceipt(int weight) {
        Integer weightPrice = factory.createParcelPriceDao().getByWeight(weight).getWeight();
        Random random = new Random();
        int cityPrice = random.nextInt(500) + 1;
        return weightPrice + cityPrice;
    }

}
