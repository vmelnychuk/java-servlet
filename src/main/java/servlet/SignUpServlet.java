package servlet;

import model.User;
import service.MapUserService;
import service.UserService;
import service.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUpServlet extends HttpServlet {
    private static UserService userService = UserServiceSingleton.getInstance();
    public static final int COOKIE_AGE = 60*60;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(0, firstName, lastName, email, password);
        userService.register(user);
        Cookie userId = new Cookie("user-id", Integer.toString(user.getId()));
        userId.setMaxAge(COOKIE_AGE);
        resp.addCookie(userId);
        resp.sendRedirect("main.jsp");
    }

}
