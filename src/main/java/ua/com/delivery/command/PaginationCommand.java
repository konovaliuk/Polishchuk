package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.entity.Direction;
import ua.com.delivery.service.DirectionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PaginationCommand implements ICommand {
    private static int PAGE = 1;
    private static final String PAGE_ID = "page";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter(PAGE_ID) != null) {
            PAGE = Integer.parseInt(request.getParameter(PAGE_ID));
        }
        int recordPerPage = 5;
        List<Direction> directionList = DirectionService.getInstance().getDirectionRecords((PAGE - 1) * recordPerPage, recordPerPage);
        int countRecords = DirectionService.getInstance().countDirectionRecords();
        int noOfPages = (int) Math.ceil(countRecords * 1.0 / recordPerPage);
        request.setAttribute("directionListP", directionList);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", PAGE);
        request.setAttribute("visibleTable", true);

        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.CONDITION_PAGE);
    }
}
