package ua.com.delivery.command.localization;

import ua.com.delivery.command.ICommand;
import ua.com.delivery.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

public class LanguageUkCommand implements ICommand {
    private static final Locale UKRAINIAN = new Locale("ua", "UA");
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getSession().setAttribute("user", null);
        Config.set(request.getSession(), Config.FMT_LOCALE, UKRAINIAN);
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
    }
}
