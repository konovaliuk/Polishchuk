package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderCommand implements ICommand{
    private static final String DATE_OF_DELIVERY = "dateOfDelivery";
    private static final String DIRECTION_ID = "directionId";
    private static final String USER_ID = "userId";
    private static final String PHONE = "phone";
    private static final String ADDRESS_OF_DELIVERY = "addressOfDelivery";
    private static final String WEIGHT_OF_PARCEL = "weightOfParcel";
    private static final String EMAIL = "email";



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;


       //////////це виправити і зробити щоб перенаправляло на успішність виконання замовлення
        ///або перехід насторінку на якій буде надпис що успішно створена заявка і на пошті всі дані
        //зроббити ще відсилку на пошту
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ORDER_PAGE);
    }
}
