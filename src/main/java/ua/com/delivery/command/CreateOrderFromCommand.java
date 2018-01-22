package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;
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
        String addressToDelivery = request.getParameter(ADDRESS_OF_DELIVERY);
        int weightOfParcel = Integer.parseInt(request.getParameter(WEIGHT_OF_PARCEL));
        String email = request.getParameter(EMAIL);
        String typeOfParcel = request.getParameter(TYPE_OF_PARCEL);
        int numberOfOrder = OrderService.getInstance().numberOfOrder();
        int totalPrice = OrderService.getInstance().totalPriceOfReceipt(weightOfParcel);

        OrderService.getInstance().createOrderFrom(request, numberOfOrder, dateOfReceipt, cityDeparture,
                userName, phone, addressToDelivery, weightOfParcel, email, totalPrice, typeOfParcel);

        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.PAYMENT_PAGE);
    }
}
