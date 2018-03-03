package com.senla.web.controller;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.service.IPersonService;
import com.senla.back.service.IPersonHandler;
import com.senla.web.controller.util.TokenUtil;
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
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        String token = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(TOKEN)){
                token = cookie.getValue();
            }
        }
        if (token == null){
            res.sendError(401);
        }

        Long userId = TokenUtil.checkToken(token);
        if (userId == null){
            res.sendError(401);
        }
        IPersonHandler personHandler = context.getBean(IPersonHandler.class);
        IPersonService personService = context.getBean(IPersonService.class);
        try {
            personHandler.setPerson(personService.getByPk(userId));
        } catch (ObjectAvailabilityException e) {
            res.sendError(501);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
