package ua.com.delivery.command;

import ua.com.delivery.persistence.dao.daoimpl.OrderFromWarehouseImpl;
import ua.com.delivery.persistence.dao.daoimpl.ParcelPriceImpl;
import ua.com.delivery.persistence.dao.AbstractFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateOrderCommand implements ICommand{
    private static final String DATE_OF_DELIVERY = "dateOfDelivery";
    private static final String CITY_DEPARTURE = "cityDeparture";
    private static final String USER_NAME = "userName";
    private static final String PHONE = "phone";
    private static final String ADDRESS_OF_DELIVERY = "addressOfDelivery";
    private static final String WEIGHT_OF_PARCEL = "weightOfParcel";
    private static final String EMAIL = "email";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        String dateOfDelivery = request.getParameter(DATE_OF_DELIVERY);
        String cityDeparture = request.getParameter(CITY_DEPARTURE);
        String userName = request.getParameter(USER_NAME);
        String phone = request.getParameter(PHONE);
        String addressOfDelivery = request.getParameter(ADDRESS_OF_DELIVERY);
        int weightOfParcel = Integer.parseInt(request.getParameter(WEIGHT_OF_PARCEL));
        String email = request.getParameter(EMAIL);

        OrderFromWarehouseImpl
        ParcelPriceImpl parcelPr = new AbstractFactory().createParcelPriceDao();
        return null;
    }
}
