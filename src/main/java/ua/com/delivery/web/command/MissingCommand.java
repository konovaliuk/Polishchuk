package ua.com.delivery.web.command;

import org.apache.log4j.Logger;
import ua.com.delivery.web.controller.utilController.PageConfiguration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MissingCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(MissingCommand.class);

    /**
     * Method for missing command from user
     * he forward to error page
     *
     * @param request
     * @param response
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
    }
}
