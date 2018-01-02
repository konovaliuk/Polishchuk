package ua.com.delivery.command;

import ua.com.delivery.command.utilCommand.UtilForCommand;
import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.entity.User;
import ua.com.delivery.service.AdministratorService;
import ua.com.delivery.service.DirectionService;
import ua.com.delivery.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginCommand implements ICommand{
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

        @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
            //извлечение из запроса логина и пароля
            String username = request.getParameter(USERNAME);
            String password = request.getParameter(PASSWORD);

            User user = LoginService.getInstance().existUsername(username);

            if (user == null) {
                page = redirectOnErrorPage(request);
            } else {
                page = checkUserPassword(request, user, password);
            }
        return null;
    }
    private String checkUserPassword(HttpServletRequest request, User user, String password) {
        String page;
        if (LoginService.getInstance().checkPasswordForUsername(user, password)){
            page = checkIfAdmin(user, request);
        } else {
            page = redirectOnErrorPage(request);
        }
        return page;

    }

    private String checkIfAdmin (User user, HttpServletRequest request){
        String page;
        if (user.isAdmin()){
            page = redirectOnAdminPage(user, request);
        } else {
            page = redirectOnUserPage(user, request);
        }
        return page;
    }

    private String redirectOnAdminPage(User user, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        session.setAttribute(UtilForCommand.USER, user);

        request.setAttribute(UtilForCommand.USERS, AdministratorService.getInstance().getAdminsAndUsers());
        request.setAttribute(USERNAME, user.getUsername());
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ADMIN_PAGE);
    }

    private String redirectOnUserPage (User user, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        session.setAttribute(UtilForCommand.USER, user);

        request.setAttribute(UtilForCommand.ADDRESS_FROM, DirectionService.getInstance().searchFromToCity());
        request.setAttribute(UtilForCommand.ADDRESS_TO, DirectionService.getInstance().searchFromToCity());

        SimpleDateFormat format = new SimpleDateFormat(UtilForCommand.DATE);
        request.setAttribute(UtilForCommand.NOW_DATE, format.format(new Date()));

        request.setAttribute(USERNAME, user.getUsername());
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.DATE);
    }
    private String redirectOnErrorPage(HttpServletRequest request){
        request.setAttribute(UtilForCommand.ERROR_MESSAGE, true);
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.LOGIN_PAGE);
    }

}
