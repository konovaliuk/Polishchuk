package ua.com.delivery.web.command;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LogoutCommandTest {
    private HttpServletRequest request = mock(HttpServletRequest.class);
    private HttpServletResponse response = mock(HttpServletResponse.class);
    private HttpSession session = mock(HttpSession.class);
    private ICommand command = new LogoutCommand();

    @Test
    public void execute() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        command.execute(request, response);
        verify(session, times(1)).invalidate();
    }
}
