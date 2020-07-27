package com.projectk.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isUserAuthenticated = true;
        if (request.getSession().getAttribute("user") == null) {
            isUserAuthenticated = false;
            response.sendRedirect("/login");
        }
        return isUserAuthenticated;
    }
}
