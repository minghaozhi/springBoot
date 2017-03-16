package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController相当于@controller加上@ResponseBody
 * Created by moShang on 2017/3/16.
 */
@RestController
public class HelloController {
    /**
     * 使用requestMapping建立请求映射
     * http://127.0.0.1:8080/hello
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "hello springBoot";
    }
}
