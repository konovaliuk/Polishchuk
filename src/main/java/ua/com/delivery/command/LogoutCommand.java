package ua.com.delivery.command;

import ua.com.delivery.command.utilCommand.UtilForCommand;
import ua.com.delivery.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.LOGIN_PAGE);
        HttpSession session = request.getSession(false);
        if (session.getAttribute("user") != null){
            session.setAttribute("user", null);
        }
        UtilForCommand.setDefaultLocale();
        return page;
    }
}
