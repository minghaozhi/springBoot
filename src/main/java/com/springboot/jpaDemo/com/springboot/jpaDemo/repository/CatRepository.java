package com.springboot.jpaDemo.com.springboot.jpaDemo.repository;

import com.springboot.jpaDemo.com.springboot.jpaDemo.bean.Cat;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/3/17.
 */
public interface CatRepository extends CrudRepository<Cat,Integer>{



}
