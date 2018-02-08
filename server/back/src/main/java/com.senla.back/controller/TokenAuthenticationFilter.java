package com.senla.back.controller;

import com.senla.back.service.ITokenHandler;
import com.senla.back.service.IUsertIdHandler;
import com.senla.back.service.TokenHandler;
import com.senla.back.service.UsertIdHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter implements Filter {


    private static final String TOKEN = "token";
    private static WebApplicationContext context;

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
        ITokenHandler tokenHandler = context.getBean(TokenHandler.class);
        tokenHandler.setToken(token);
        IUsertIdHandler idHandler = context.getBean(UsertIdHandler.class);
        //>idHandler.setId(TokenUtil.getUserId(token));
        filterChain.doFilter(servletRequest, servletResponse);  // Разрешить request продвигаться дальше.
    }

    @Override
    public void destroy() {

    }
}
