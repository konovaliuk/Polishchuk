package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.*;
import ua.com.delivery.persistence.dao.daoimpl.OrderFromWarehouseImpl;
import ua.com.delivery.persistence.dao.daoimpl.OrderToWarehouseImpl;
import ua.com.delivery.persistence.entity.OrderFromWarehouse;
import ua.com.delivery.persistence.entity.OrderToWarehouse;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class OrderService {
    private static final Logger LOGGER = Logger.getLogger(OrderService.class);
    private static OrderService INSTANCE;

//    private IAbstractFactory factory;
    private AbstractFactory factory;


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

        IUserDao userDao = factory.createUserDao();
        IDirectionDao directionDao = factory.createDirectionDao();
        IParcelPriceDao parcelPriceDao = factory.createParcelPriceDao();
        OrderFromWarehouseImpl orderFromWarehouseImpl = factory.createOrderFromWarehouseDao();
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

    public void createOrderTo(HttpServletRequest request, Date dateOfDelivery, String addressOfDeparture,
                              String cityReceipt, String userName, int phone, int weightOfParcel, String email,
                              String typeOfParcel) {

        IUserDao userDao = factory.createUserDao();
        IDirectionDao directionDao = factory.createDirectionDao();
        IParcelPriceDao parcelPriceDao = factory.createParcelPriceDao();
        OrderToWarehouseImpl orderToWarehouseImpl = factory.createOrderToWarehouseDao();
        OrderToWarehouse orderToWarehouse = new OrderToWarehouse();
        orderToWarehouse.setDateOfDeparture(dateOfDelivery);
        orderToWarehouse.setDepartureAddress(addressOfDeparture);
        orderToWarehouse.setCityOfReceipt(cityReceipt);
        orderToWarehouse.setUserName(userName);
        orderToWarehouse.setPhone(phone);
        orderToWarehouse.setWeight(weightOfParcel);
        orderToWarehouse.setEmail(email);
        orderToWarehouse.setTypeOfParcel(typeOfParcel);
        orderToWarehouse.setNumberOfOrder(numberOfOrder());
        orderToWarehouse.setTotalPrice(totalPriceOfReceipt(weightOfParcel));
        orderToWarehouse.setUserId(userDao.getUserByUsername((String) request.getSession().getAttribute("visibleUser")).getUserID());
        orderToWarehouse.setDirectionId(directionDao.getDirectionByFromCity(cityReceipt).getDirectionID());
        orderToWarehouse.setParcelPriceId(parcelPriceDao.getByWeight(weightOfParcel).getParcelpriceID());
        orderToWarehouseImpl.createOrderToWarehouse(orderToWarehouse);
        request.setAttribute("totalPriceOfDelivery", totalPriceOfReceipt(weightOfParcel));
    }


    public Integer numberOfOrder() {
        return (int)(Math.random()*666+1);
    }

    public Integer totalPriceOfReceipt(int weight) {
        Integer weightPrice = factory.createParcelPriceDao().getByWeight(weight).getWeight();
        int cityPrice = (int)(Math.random()* 500 + 1);
        return weightPrice + cityPrice;
    }

}
