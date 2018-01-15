package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.daoimpl.OrderFromWarehouseImpl;
import ua.com.delivery.persistence.entity.OrderFromWarehouse;
import ua.com.delivery.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CreateOrderFromCommand implements ICommand{
    private static final String DATE_OF_RECEIPT = "dateOfReceipt";
    private static final String DATE_OF_DELIVERY = "dateOfDelivery";
    private static final String CITY_DEPARTURE = "cityDeparture";
    private static final String CITY_RECEIPT = "cityReceipt";
    private static final String USER_NAME = "userName";
    private static final String PHONE = "phone";
    private static final String ADDRESS_OF_DELIVERY = "addressOfDelivery";
    private static final String ADDRESS_OF_DEPARTURE = "addressOfDeparture";
    private static final String WEIGHT_OF_PARCEL = "weightOfParcel";
    private static final String EMAIL = "email";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        Date dateOfReceipt = Date.valueOf(request.getParameter(DATE_OF_RECEIPT));
//        Date dateOfDelivery = Date.valueOf(request.getParameter(DATE_OF_DELIVERY));
        String cityDeparture = request.getParameter(CITY_DEPARTURE);
//        String cityReceipt = request.getParameter(CITY_RECEIPT);
        String userName = request.getParameter(USER_NAME);
        int phone = Integer.parseInt(request.getParameter(PHONE));
        String addressOfDelivery = request.getParameter(ADDRESS_OF_DELIVERY);
//        String addressOfDeparture = request.getParameter(ADDRESS_OF_DEPARTURE);
        int weightOfParcel = Integer.parseInt(request.getParameter(WEIGHT_OF_PARCEL));
        String email = request.getParameter(EMAIL);

        int numberOfOrder = OrderService.getInstance().numberOfOrder();
        int totalPrice = OrderService.getInstance().totalPriceOfReceipt(weightOfParcel);

//        if (dateOfDelivery != null && cityReceipt != null && addressOfDeparture != null){
//            OrderToWarehouseImpl orderToWarehouseImpl = new AbstractFactory().createOrderToWarehouseDao();
//            OrderToWarehouse orderToWarehouse = new OrderToWarehouse();
//            orderToWarehouse.setDateOfDeparture(dateOfDelivery);
//            orderToWarehouse.setDepartureAddress(addressOfDeparture);
//            orderToWarehouse.setCityOfReceipt(cityReceipt);
//            orderToWarehouse.setUserName(userName);
//            orderToWarehouse.setPhone(phone);
//            orderToWarehouse.setWeight(weightOfParcel);
//            orderToWarehouse.setEmail(email);
//            orderToWarehouse.setNumberOfOrder(numberOfOrder);
//            orderToWarehouse.setTotalPrice(totalPrice);
//
//            orderToWarehouseImpl.createOrderToWarehouse(orderToWarehouse);
//
//        } else {
            OrderFromWarehouseImpl orderFromWarehouseImpl = new AbstractFactory().createOrderFromWarehouseDao();
            OrderFromWarehouse orderFromWarehouse = new OrderFromWarehouse();
            orderFromWarehouse.setNumberOfOrder(numberOfOrder);
            orderFromWarehouse.setDateToDelivery(dateOfReceipt);
            orderFromWarehouse.setCityDeparture(cityDeparture);
            orderFromWarehouse.setUserName(userName);
            orderFromWarehouse.setPhone(phone);
            orderFromWarehouse.setAddressToDelivery(addressOfDelivery);
            orderFromWarehouse.setWeight(weightOfParcel);
            orderFromWarehouse.setEmail(email);
            orderFromWarehouse.setTotalPrice(totalPrice);

            orderFromWarehouseImpl.createOrderFromWarehouse(orderFromWarehouse);
//        }



        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ORDER_PAGE);
    }
}
