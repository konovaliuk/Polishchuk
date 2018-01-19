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

public class CreateOrderFromCommand implements ICommand {
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String USER_NAME = "userName";
    private static final String TYPE_OF_PARCEL = "typeOfParcel";
    private static final String CITY_DEPARTURE = "cityDeparture";
    private static final String DATE_OF_RECEIPT = "dateOfReceipt";
    private static final String WEIGHT_OF_PARCEL = "weightOfParcel";
    private static final String ADDRESS_OF_DELIVERY = "addressOfDelivery";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date dateOfReceipt = Date.valueOf(request.getParameter(DATE_OF_RECEIPT));
        String cityDeparture = request.getParameter(CITY_DEPARTURE);
        String userName = request.getParameter(USER_NAME);
        int phone = Integer.parseInt(request.getParameter(PHONE));
        String addressOfDelivery = request.getParameter(ADDRESS_OF_DELIVERY);
        int weightOfParcel = Integer.parseInt(request.getParameter(WEIGHT_OF_PARCEL));
        String email = request.getParameter(EMAIL);
        String typeOfParcel = request.getParameter(TYPE_OF_PARCEL);

        Integer numberOfOrder = OrderService.getInstance().numberOfOrder();
        Integer totalPrice = OrderService.getInstance().totalPriceOfReceipt(weightOfParcel);

        request.setAttribute("totalPriceOfReceipt", totalPrice);

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
        orderFromWarehouse.setTypeOfParcel(typeOfParcel);

        orderFromWarehouseImpl.createOrderFromWarehouse(orderFromWarehouse);

        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.PAYMENT_PAGE);
    }
}
