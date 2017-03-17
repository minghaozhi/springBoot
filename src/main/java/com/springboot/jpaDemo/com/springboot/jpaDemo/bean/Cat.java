package com.springboot.jpaDemo.com.springboot.jpaDemo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**实体类
 * 使用@Entity进行持久化操作，党jpa检测到有这个注解，会在数据库生成对应的表结构信息
 * 使用@Id
 * Created by Administrator on 2017/3/17.
 */
@Entity
public class Cat {
    /**
     * 使用@  Id指定主键
     */
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String catName;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
