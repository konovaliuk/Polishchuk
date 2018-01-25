package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.*;
import ua.com.delivery.persistence.dao.daoimpl.OrderFromWarehouseImpl;
import ua.com.delivery.persistence.dao.daoimpl.OrderToWarehouseImpl;
import ua.com.delivery.persistence.entity.OrderFromWarehouse;
import ua.com.delivery.persistence.entity.OrderToWarehouse;
import ua.com.delivery.web.controller.utilController.MessageHelper;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class OrderService {
    private static final Logger LOGGER = Logger.getLogger(OrderService.class);
    private static OrderService INSTANCE;

    private IAbstractFactory factory;


    private OrderService() {
        factory = new AbstractFactory();
    }

    /**
     * Singleton
     *
     * @return INSTANCE
     */
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

    /**
     * Method for create order from warehouse
     *
     * @param request
     * @param dateOfReceipt
     * @param cityDeparture
     * @param userName
     * @param phone
     * @param addressToDelivery
     * @param weightOfParcel
     * @param email
     * @param typeOfParcel
     */
    public void createOrderFrom(HttpServletRequest request, Date dateOfReceipt, String cityDeparture, String userName,
                                String phone, String addressToDelivery,
                                int weightOfParcel, String email, String typeOfParcel) {

        boolean emailOk = Validation.getInstance().validEmail(email);
        boolean phoneOk = Validation.getInstance().validPhone(phone);
        IUserDao userDao = factory.createUserDao();
        IDirectionDao directionDao = factory.createDirectionDao();
        IParcelPriceDao parcelPriceDao = factory.createParcelPriceDao();
        int totalPriceOfRec = totalPriceOfReceipt(weightOfParcel);
        OrderFromWarehouseImpl orderFromWarehouseImpl = factory.createOrderFromWarehouseDao();
        OrderFromWarehouse orderFromWarehouse = new OrderFromWarehouse();
        orderFromWarehouse.setNumberOfOrder(numberOfOrder());
        orderFromWarehouse.setDateToDelivery(dateOfReceipt);
        orderFromWarehouse.setCityDeparture(cityDeparture);
        orderFromWarehouse.setUserName(userName);
        if (phoneOk){
            orderFromWarehouse.setPhone(phone);
        }else {
            request.setAttribute("phoneBoolean", true);
            request.setAttribute("phoneException",
                    MessageHelper.getInstance().getMessageException(MessageHelper.PHONE_EXCEPTION));
            return;
        }
        orderFromWarehouse.setAddressToDelivery(addressToDelivery);
        orderFromWarehouse.setWeight(weightOfParcel);
        if (emailOk ) {
            orderFromWarehouse.setEmail(email);
        } else {
            request.setAttribute("emailBoolean", true);
            request.setAttribute("emailException",
                    MessageHelper.getInstance().getMessageException(MessageHelper.EMAIL_EXCEPTION));
            return;
        }
        orderFromWarehouse.setTotalPrice(totalPriceOfRec);
        orderFromWarehouse.setTypeOfParcel(typeOfParcel);
        orderFromWarehouse.setUserId(userDao.getUserByUsername((String) request.getSession().getAttribute("visibleUser")).getUserID());
        orderFromWarehouse.setDirectionId(directionDao.getDirectionByFromCity(cityDeparture).getDirectionID());
        orderFromWarehouse.setParcelPriceId(parcelPriceDao.getByWeight(weightOfParcel).getParcelpriceID());
        orderFromWarehouseImpl.createOrderFromWarehouse(orderFromWarehouse);
        request.getSession().setAttribute("totalPriceOfReceipt", totalPriceOfRec);
        request.getSession().setAttribute("visibleAllOrder", true);
        LOGGER.info("Was successful created order from warehouse");
    }

    /**
     * Method for create order from warehouse
     *
     * @param request
     * @param dateOfDelivery
     * @param addressOfDeparture
     * @param userName
     * @param phone
     * @param cityReceipt
     * @param weightOfParcel
     * @param email
     * @param typeOfParcel
     */
    public void createOrderTo(HttpServletRequest request, Date dateOfDelivery, String addressOfDeparture,
                              String cityReceipt, String userName, String phone, int weightOfParcel, String email,
                              String typeOfParcel) {

        boolean emailOk = Validation.getInstance().validEmail(email);
        boolean phoneOk = Validation.getInstance().validPhone(phone);
        IUserDao userDao = factory.createUserDao();
        IDirectionDao directionDao = factory.createDirectionDao();
        IParcelPriceDao parcelPriceDao = factory.createParcelPriceDao();
        int totalPriceOfRec = totalPriceOfReceipt(weightOfParcel);
        OrderToWarehouseImpl orderToWarehouseImpl = factory.createOrderToWarehouseDao();
        OrderToWarehouse orderToWarehouse = new OrderToWarehouse();
        orderToWarehouse.setDateOfDeparture(dateOfDelivery);
        orderToWarehouse.setDepartureAddress(addressOfDeparture);
        orderToWarehouse.setCityOfReceipt(cityReceipt);
        orderToWarehouse.setUserName(userName);
        if (phoneOk){
            orderToWarehouse.setPhone(phone);
        }else {
            request.setAttribute("phoneBoolean", true);
            request.setAttribute("phoneException",
                    MessageHelper.getInstance().getMessageException(MessageHelper.PHONE_EXCEPTION));
            return;
        }
        orderToWarehouse.setWeight(weightOfParcel);
        if (emailOk ) {
            orderToWarehouse.setEmail(email);
        } else {
            request.setAttribute("emailBoolean", true);
            request.setAttribute("emailException",
                    MessageHelper.getInstance().getMessageException(MessageHelper.EMAIL_EXCEPTION));
            return;
        }
        orderToWarehouse.setTypeOfParcel(typeOfParcel);
        orderToWarehouse.setNumberOfOrder(numberOfOrder());
        orderToWarehouse.setTotalPrice(totalPriceOfRec);
        orderToWarehouse.setUserId(userDao.getUserByUsername((String) request.getSession().getAttribute("visibleUser")).getUserID());
        orderToWarehouse.setDirectionId(directionDao.getDirectionByFromCity(cityReceipt).getDirectionID());
        orderToWarehouse.setParcelPriceId(parcelPriceDao.getByWeight(weightOfParcel).getParcelpriceID());
        orderToWarehouseImpl.createOrderToWarehouse(orderToWarehouse);
        request.getSession().setAttribute("totalPriceOfDelivery", totalPriceOfRec);
        request.getSession().setAttribute("visibleAllOrder", true);
        LOGGER.info("Was successful created order to warehouse");
    }

    /**
     * Method for create order from warehouse
     *
     * @return numberOfOrder
     */
    private Integer numberOfOrder() {
        return (int) (Math.random() * 666 + 1);
    }

    /**
     * Method for create order from warehouse
     *
     * @param weight
     * @return totalPriceOfReceipt
     */
    private Integer totalPriceOfReceipt(int weight) {
        Integer weightPrice = factory.createParcelPriceDao().getByWeight(weight).getWeight();
        int cityPrice = (int) (Math.random() * 500 + 1);
        return weightPrice + cityPrice;
    }




}
