package ua.com.delivery.command;

import ua.com.delivery.service.DirectionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaginationCommand implements ICommand{
    private static final String NUM_PAGE = "numPage";
    public static final int DEFAULT_RECORDS_PER_PAGE = 3;




    /*
     * read pageNumber parameter wrap it into integer store it in page number variable
     */

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = 0;
        int totalNumberOfRecords = DirectionService.getInstance().countDirecetionRecords();
        int startIndex = 0;
        int numberOfPages = 0;

        String sNumPage = request.getParameter(NUM_PAGE);
        pageNumber = Integer.parseInt(sNumPage);

        /*
        *find starting point to display the records select directions from table
        * move the cursor to starting point use loop and display directions on browser(3)        *
        */
        try {
            startIndex = (pageNumber * DEFAULT_RECORDS_PER_PAGE) - DEFAULT_RECORDS_PER_PAGE + 1;
        } catch (Exception e) {

        }

        return null;
    }
}
