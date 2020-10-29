package cn.usian.controller;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object stu = request.getSession().getAttribute("stu");
        String uri = request.getRequestURI();

        if (stu != null){
            return true;
        }
        response.sendRedirect("toLogin");


        return false;
    }
}
