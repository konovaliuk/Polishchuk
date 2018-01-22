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

public class CalculatorCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(CalculatorCommand.class);

    /**
     * Method for forward on calculator page
     * he shows all city for delivery
     *
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Direction> list = DirectionService.getInstance().searchFromToCity();
        request.getSession().setAttribute("listFromToCity", list);
        LOGGER.info("To the page was added all list of cities");
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.CALCULATOR_PAGE);
    }
}
