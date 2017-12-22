package ua.com.delivery.controller.filters;

import javax.servlet.*;
import java.io.IOException;

public class FilterForEncoding implements Filter {

    private FilterConfig filterConfig = null;

    //Intitialization method
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //Setting the character set for the request
        request.setCharacterEncoding("UTF-8");

        // pass the request on
        chain.doFilter(request,response);

        //Setting the character set for the response
        response.setContentType("text/html; charset=UTF-8");
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
