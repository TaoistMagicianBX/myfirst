package cn.usian.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class GlobalExceptionResolver implements HandlerExceptionResolver {



    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof ArithmeticException){
            modelAndView.setViewName("arerror");
            modelAndView.addObject("msg",e.toString());
        }
        if (e instanceof NullPointerException){
            modelAndView.setViewName("nullerror");
            modelAndView.addObject("msg",e.toString());
        }


        return modelAndView;


    }
}
