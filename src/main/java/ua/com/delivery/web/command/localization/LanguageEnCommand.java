package ua.com.delivery.web.command.localization;

import org.apache.log4j.Logger;
import ua.com.delivery.web.command.ICommand;
import ua.com.delivery.web.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

public class LanguageEnCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(LanguageEnCommand.class);

    /**
     * Method for change language to en
     *
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Config.set(request.getSession(false), Config.FMT_LOCALE, Locale.ENGLISH);
        LOGGER.info("Language was changed on EN");
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
    }

}
