package ua.com.delivery.command.locale;

import ua.com.delivery.command.ICommand;
import ua.com.delivery.command.utilCommand.UtilForCommand;
import ua.com.delivery.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

public class SetLocaleUaCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(false).setAttribute("user", null);
        UtilForCommand.setLocale(UtilForCommand.UKRAINIAN);
        Config.set(request.getSession(), Config.FMT_LOCALE, UtilForCommand.UKRAINIAN);
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
    }
}
