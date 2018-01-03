package ua.com.delivery.controller.filters;

import javax.servlet.*;
import java.io.IOException;

public class FilterForEncoding implements Filter {
    // кодировка
    private String encoding;

    @Override
    public void init(FilterConfig config) throws ServletException
    {
        // читаем из конфигурации
        encoding = config.getInitParameter("requestEncoding");

        // если не установлена - устанавливаем UTF-8
        if( encoding==null ) encoding="UTF-8";
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException
    {
        request.setCharacterEncoding(encoding);
        next.doFilter(request, response);
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

