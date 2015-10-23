package servlet;

import model.User;
import service.UserService;
import service.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LogOutServlet extends HttpServlet {
    private static UserService userService = UserServiceSingleton.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = 0;
        Cookie[] cookies = req.getCookies();
        for(int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if(cookie.getName().equals("user-id")) {
                userId = Integer.valueOf(cookie.getValue());
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        User user = userService.getById(userId);
        userService.logout(user);
        resp.sendRedirect("main.jsp");
    }
}
