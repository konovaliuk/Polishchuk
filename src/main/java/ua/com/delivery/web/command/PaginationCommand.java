package ua.com.delivery.web.command;

import org.apache.log4j.Logger;
import ua.com.delivery.web.controller.utilController.PageConfiguration;
import ua.com.delivery.service.PaginationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaginationCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(PaginationCommand.class);
    private static final String PAGE_PARAM = "page";

    /**
     * Method for pagination (pages on condition page)
     *
     * @param request
     * @param response
     * @return page
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaginationService.getInstance().conditionPagination(request, PAGE_PARAM);
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.CONDITION_PAGE);
    }
}
