package com.springboot.jpaDemo.com.springboot.jpaDemo.config;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ControllerAdvice
 * Created by Administrator on 2017/3/17.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest request,Exception e){
        //返回的string
        return "对不起,服务器繁忙,请稍后再试";

    }
}
