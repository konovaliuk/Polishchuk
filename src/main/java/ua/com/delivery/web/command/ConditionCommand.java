package ua.com.delivery.web.command;

import org.apache.log4j.Logger;
import ua.com.delivery.web.controller.utilController.PageConfiguration;
import ua.com.delivery.service.DirectionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConditionCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(ConditionCommand.class);

    /**
     * Method for forward on condition page
     * he shows table of tariffing
     *
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer countRecord = DirectionService.getInstance().countDirectionRecords();
        request.getSession().setAttribute("countRecord", countRecord);
        LOGGER.info("Was showed table with tariff");
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.CONDITION_PAGE);
    }
}
