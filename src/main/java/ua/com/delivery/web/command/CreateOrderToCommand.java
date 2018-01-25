package ua.com.delivery.web.command;

import org.apache.log4j.Logger;
import ua.com.delivery.web.controller.utilController.PageConfiguration;
import ua.com.delivery.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CreateOrderToCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(CreateOrderToCommand.class);
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String USER_NAME = "userName";
    private static final String CITY_RECEIPT = "cityReceipt";
    private static final String TYPE_OF_PARCEL = "typeOfParcel";
    private static final String DATE_OF_DELIVERY = "dateOfDelivery";
    private static final String WEIGHT_OF_PARCEL = "weightOfParcel";
    private static final String ADDRESS_OF_DEPARTURE = "addressOfDeparture";


    /**
     * Method for forward on orderToWarehouse page
     * he helps to create order to warehouse
     *
     * @param request
     * @param response
     * @return page
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date dateOfDelivery = Date.valueOf(request.getParameter(DATE_OF_DELIVERY));
        String cityReceipt = request.getParameter(CITY_RECEIPT);
        String userName = request.getParameter(USER_NAME);
        String phone = request.getParameter(PHONE);
        String addressOfDeparture = request.getParameter(ADDRESS_OF_DEPARTURE);
        int weightOfParcel = Integer.parseInt(request.getParameter(WEIGHT_OF_PARCEL));
        String email = request.getParameter(EMAIL);
        String typeOfParcel = request.getParameter(TYPE_OF_PARCEL);

        OrderService.getInstance().createOrderTo(request, dateOfDelivery, addressOfDeparture, cityReceipt, userName,
                phone, weightOfParcel, email, typeOfParcel);
//        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ORDER_PAGE);
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.PAYMENT_PAGE);
    }
}
