package ua.com.delivery.web.command;

import ua.com.delivery.web.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeCommand implements ICommand {
    /**
     * Method for forward on home(main) page
     *
     * @param request
     * @param response
     * @return page
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
    }
}
