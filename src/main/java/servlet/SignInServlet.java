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

public class SignInServlet extends HttpServlet {
    private static UserService userService = UserServiceSingleton.getInstance();
    public static final int COOKIE_AGE = 60*60;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(email + " " + password);
        User user = User.userForLogin(email, password);
        user = userService.login(user);
        if (user != null) {
            Cookie userId = new Cookie("user-id", Integer.toString(user.getId()));
            userId.setMaxAge(COOKIE_AGE);
            resp.addCookie(userId);
            resp.sendRedirect("main.jsp");
        } else {
            out.write("No such user");
            resp.setHeader("Refresh", "5;url=main.jsp");
        }
    }
}
