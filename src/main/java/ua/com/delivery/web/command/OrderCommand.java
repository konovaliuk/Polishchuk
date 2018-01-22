package ua.com.delivery.web.command;

import org.apache.log4j.Logger;
import ua.com.delivery.web.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.entity.Direction;
import ua.com.delivery.service.DirectionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(OrderCommand.class);

    /**
     * Method for order delivery
     *
     * @param request
     * @param response
     * @return page
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Direction> directionList = DirectionService.getInstance().searchFromToCity();
        request.getSession().setAttribute("cityFromTo", directionList);
        LOGGER.info("Was forward to order page");
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ORDER_PAGE);
    }
}
