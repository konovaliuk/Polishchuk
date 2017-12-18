package ua.com.delivery.controller;

import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;
import ua.com.delivery.persistence.dao.daoimpl.CargoPriceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IAbstractFactory factory = new AbstractFactory();
        CargoPriceImpl cargoPrice = factory.createCargoDao();
//        cargoPrice.createCargoPrice(new CargoPrice(11L, 5,8));
        cargoPrice.deleteCargoPriceByWeight(5);

        request.getRequestDispatcher("WEB-INF/pages/loginPage.jsp").forward(request,response);
       /* Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }
        Cookie cookie = new Cookie("testCookie", "valuecookie");
        //время жизни куки 5с
//        cookie.setMaxAge(5);

        //тільки по цій урлі буде працювати кукі
//        cookie.setPath("/someLink");

         //кукі будуть видні якщо тільки https зєднання
        cookie.setSecure(true);
        response.addCookie(cookie);*/
//            request.getRequestDispatcher("WEB-INF/pages/registration.jsp").forward(request,response);
    }
}
