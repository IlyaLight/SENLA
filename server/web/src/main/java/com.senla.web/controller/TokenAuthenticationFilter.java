package com.senla.web.controller;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.service.IUserService;
import com.senla.back.service.IUsertHandler;
import com.senla.back.service.UserHandler;
import com.senla.back.service.UserService;
import com.senla.web.controller.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter implements Filter {


    private static final String TOKEN = "token";
    private WebApplicationContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        String token = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(TOKEN)){
                token = cookie.getValue();
            }
        }
        if (token == null){
            res.sendError(401); //Unauthorized
        }
        //>checkToken

        Integer userId = TokenUtil.checkToken(token);
        if (userId == null){
            res.sendError(401); //Unauthorized
        }
        IUsertHandler usertHandler = context.getBean(IUsertHandler.class);
        IUserService userService = context.getBean(IUserService.class);
        try {
            usertHandler.setUser(userService.getByPk(userId));
        } catch (ObjectAvailabilityException e) {
            res.sendError(501);
        }
        filterChain.doFilter(servletRequest, servletResponse);  // Разрешить request продвигаться дальше.
    }

    @Override
    public void destroy() {

    }
}
