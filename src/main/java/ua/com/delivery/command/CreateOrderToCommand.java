package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.daoimpl.OrderToWarehouseImpl;
import ua.com.delivery.persistence.entity.OrderToWarehouse;
import ua.com.delivery.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CreateOrderToCommand implements ICommand {
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String USER_NAME = "userName";
    private static final String CITY_RECEIPT = "cityReceipt";
    private static final String TYPE_OF_PARCEL = "typeOfParcel";
    private static final String DATE_OF_DELIVERY = "dateOfDelivery";
    private static final String WEIGHT_OF_PARCEL = "weightOfParcel";
    private static final String ADDRESS_OF_DEPARTURE = "addressOfDeparture";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date dateOfDelivery = Date.valueOf(request.getParameter(DATE_OF_DELIVERY));
        String cityReceipt = request.getParameter(CITY_RECEIPT);
        String userName = request.getParameter(USER_NAME);
        int phone = Integer.parseInt(request.getParameter(PHONE));
        String addressOfDeparture = request.getParameter(ADDRESS_OF_DEPARTURE);
        int weightOfParcel = Integer.parseInt(request.getParameter(WEIGHT_OF_PARCEL));
        String email = request.getParameter(EMAIL);
        String typeOfParcel = request.getParameter(TYPE_OF_PARCEL);

        int numberOfOrder = OrderService.getInstance().numberOfOrder();
        int totalPrice = OrderService.getInstance().totalPriceOfReceipt(weightOfParcel);

        request.setAttribute("totalPriceOfDelivery", totalPrice);

        OrderToWarehouseImpl orderToWarehouseImpl = new AbstractFactory().createOrderToWarehouseDao();
        OrderToWarehouse orderToWarehouse = new OrderToWarehouse();
        orderToWarehouse.setDateOfDeparture(dateOfDelivery);
        orderToWarehouse.setDepartureAddress(addressOfDeparture);
        orderToWarehouse.setCityOfReceipt(cityReceipt);
        orderToWarehouse.setUserName(userName);
        orderToWarehouse.setPhone(phone);
        orderToWarehouse.setWeight(weightOfParcel);
        orderToWarehouse.setEmail(email);
        orderToWarehouse.setTypeOfParcel(typeOfParcel);
        orderToWarehouse.setNumberOfOrder(numberOfOrder);
        orderToWarehouse.setTotalPrice(totalPrice);

        orderToWarehouseImpl.createOrderToWarehouse(orderToWarehouse);

        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.PAYMENT_PAGE);
    }
}
