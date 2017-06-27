package com.springboot.controller;

import com.springboot.test.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

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
        return "hello springBoot11";
    }

    @RequestMapping(value = "/getDemo" )
   public Demo getDemo(){
        Demo demo=new Demo();
        demo.setId(1l);
        demo.setName("张三");
        demo.setCreateTime(new Date());
        demo.setRemark("这是备注信息");
        return  demo;
   }

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index.html");
    }
}
