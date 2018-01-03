package ua.com.delivery.controller.filters;

import javax.servlet.*;
import java.io.IOException;

public class FilterForEncoding implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletRequest.getLocale();
        servletResponse.setLocale(servletRequest.getLocale());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
//    private String encoding = "UTF-8";
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain filterChain) throws IOException, ServletException {
//        request.setCharacterEncoding(encoding);
//        filterChain.doFilter(request, response);
//        response.setContentType("text/html; charset=UTF-8");
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        String encodingParam = filterConfig.getInitParameter("encoding");
//        if (encodingParam != null) {
//            encoding = encodingParam;
//        }
//
//    }
//
//    @Override
//    public void destroy() {}
}

