package com.springboot.jpaDemo.com.springboot.jpaDemo.controller;

import com.springboot.jpaDemo.com.springboot.jpaDemo.bean.Cat;
import com.springboot.jpaDemo.com.springboot.jpaDemo.service.CatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/17.
 */
@RestController
@RequestMapping("/cat")
public class CatController {
@Resource
private CatService catService;

    @RequestMapping("/save")
    public String save(){
        Cat cat=new Cat();
        cat.setAge(11);
        cat.setCatName("花猫");
        catService.save(cat);
        return "save ok";
    }
    @RequestMapping("/delete")
    public String delete(){
        catService.delete(1);
        return "delete ok";
    }
    @RequestMapping("/getAll")
    public Iterable<Cat> getAll(){
       return catService.getAll();

    }
    @RequestMapping("/selectByCatName")
    public Cat selectByCatName(String catName){
        return  catService.selectByCatName(catName);
    }
}
