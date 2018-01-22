package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;
import ua.com.delivery.persistence.entity.Direction;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PaginationService {
    private static final Logger LOGGER = Logger.getLogger(PaginationService.class);
    private static PaginationService INSTANCE;

    private PaginationService() {
        IAbstractFactory factory = new AbstractFactory();
    }

    /**
     * Singleton
     *
     * @return INSTANCE
     */
    public static PaginationService getInstance() {
        if (INSTANCE == null) {
            synchronized (PaginationService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PaginationService();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Method for pagination
     *
     * @param request
     * @param parameterPage
     */
    public void conditionPagination(HttpServletRequest request, String parameterPage) {
        int startPage = 1;
        if (request.getParameter(parameterPage) != null) {
            startPage = Integer.parseInt(request.getParameter(parameterPage));
        }
        int recordPerPage = 5;
        List<Direction> directionList = DirectionService.getInstance().
                getDirectionRecords((startPage - 1) * recordPerPage, recordPerPage);
        int countRecords = DirectionService.getInstance().countDirectionRecords();
        int noOfPages = (int) Math.ceil(countRecords * 1.0 / recordPerPage);
        request.setAttribute("directionListP", directionList);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", startPage);
        request.setAttribute("visibleTable", true);
    }
}
