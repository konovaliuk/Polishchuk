package ua.com.delivery.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.daoimpl.UserImpl;
import ua.com.delivery.persistence.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @Mock
    private User user;

    @Mock
    private UserImpl userDao;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @Mock
    private AbstractFactory factory;

    @InjectMocks
    private LoginService loginService;


    @Before
    public void setUp(){
        user = new User();
        user.setUsername("TestUsername");
        user.setFirstName("Kolya");
        user.setSecondName("Kurochkin");
        user.setPassword("password");

        when(userDao.getUserByUsername(user.getUsername())).thenReturn(user);
        when(factory.createUserDao()).thenReturn(userDao);
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testExistUsername(){
        User kolya = loginService.existUsername(user.getUsername());
        assertEquals(user.getUsername(), kolya.getUsername());
        assertEquals(user.getFirstName(), kolya.getFirstName());
        assertEquals(user.getSecondName(), kolya.getSecondName());
    }

    @Test
    public void testCheckUserPassword(){
        user.setAdmin(true);
        String checkResultAdmin = loginService.checkUserPassword(request, user, "password");
        assertEquals("/pages/adminPage.jsp", checkResultAdmin);

        user.setAdmin(false);
        String checkResultUser = loginService.checkUserPassword(request, user, "password");
        assertEquals("/index.jsp", checkResultUser);
    }

    @Test
    public void testRedirectOnErrorPage(){
        String errorPage = loginService.redirectOnErrorPage(request);
        assertEquals("/pages/loginPage.jsp", errorPage);
    }

}
