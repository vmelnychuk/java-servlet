package filter;

import model.UrlVisiting;
import service.HintService;
import service.HintServiceCollection;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HintsCount implements Filter {
    private HintService hintService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        HintService hintService = new HintServiceCollection();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURL().toString();
        int userId = 0;
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("user-id")) {
                userId = new Integer(cookie.getValue());
            }
        }
        UrlVisiting visit = new UrlVisiting(userId, url, 1);
        hintService.add(visit);
    }

    @Override
    public void destroy() {
        hintService = null;
    }
}
