package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.daoimpl.UserImpl;
import ua.com.delivery.persistence.entity.User;
import ua.com.delivery.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCommand  implements ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String firstName = request.getParameter("firstName").trim();
        String secondName = request.getParameter("secondName").trim();
        String email = request.getParameter("email").trim();
        String address = request.getParameter("address").trim();
        String city = request.getParameter("city").trim();
        Long phone = Long.valueOf(request.getParameter("phone").trim());

        if (LoginService.getInstance().existUsername(username) == null){
//            IAbstractFactory factory = new AbstractFactory();
//            UserImpl user = factory.createUserDao();
            UserImpl userImpl = new AbstractFactory().createUserDao();
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            user.setEmail(email);
            user.setAddress(address);
            user.setCity(city);
            user.setPhone(phone);
            user.setAdmin(false);

            userImpl.createUser(user);
        if (user.getUserID() == null){
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
        } else {
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.LOGIN_PAGE);
        }
        } else {
            request.setAttribute("You have some thouble, bro", true);
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
        }
        return page;
    }
}
