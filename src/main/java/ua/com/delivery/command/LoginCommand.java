package ua.com.delivery.command;

import ua.com.delivery.command.utilCommand.UtilForCommand;
import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.entity.User;
import ua.com.delivery.service.AdministratorService;
import ua.com.delivery.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ICommand{
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";


        @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
            String page = null;
            //извлечение из запроса логина и пароля
//            if (request.getParameter("sub") != null && request.getParameter("sub").equals("sub")) {
            String username = request.getParameter(USERNAME);
            String password = request.getParameter(PASSWORD);
//            System.out.println(username);
//            System.out.println(password);

            User user = LoginService.getInstance().existUsername(username);

            if (user == null) {
                page = redirectOnErrorPage(request);
            } else {
                page = checkUserPassword(request, user, password);
            }
//        }
            //<сторінка на якій буде привітання для юзера
            request.getSession().setAttribute("user", username);
        return page;
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
        if (user.getAdmin()){
            page = redirectOnAdminPage(user, request);
        } else {
            page = redirectOnUserPage(user, request);
        }
        return page;
    }

    private String redirectOnAdminPage(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute(UtilForCommand.USER, user);

        request.setAttribute(UtilForCommand.USERS, AdministratorService.getInstance().getAdminsAndUsers());
        request.setAttribute(USERNAME, user.getUsername());
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ADMIN_PAGE);
    }

    //////розібратись
    private String redirectOnUserPage (User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute(UtilForCommand.USER, user);

//        request.setAttribute(UtilForCommand.ADDRESS_FROM, DirectionService.getInstance().searchFromToCity());
//        request.setAttribute(UtilForCommand.ADDRESS_TO, DirectionService.getInstance().searchFromToCity());
//
//        SimpleDateFormat format = new SimpleDateFormat(UtilForCommand.DATE);
//        request.setAttribute(UtilForCommand.NOW_DATE, format.format(new Date()));

        request.setAttribute(USERNAME, user.getUsername());
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.HOME_PAGE);
    }


    private String redirectOnErrorPage(HttpServletRequest request){
        request.setAttribute(UtilForCommand.ERROR_MESSAGE, true);
//        перенапралвення на логін пейдж, якщоне правильно ввів логігн
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.LOGIN_PAGE);
    }

}
