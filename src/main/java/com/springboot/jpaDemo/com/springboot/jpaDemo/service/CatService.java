package com.springboot.jpaDemo.com.springboot.jpaDemo.service;

import com.springboot.jpaDemo.com.springboot.jpaDemo.bean.Cat;
import com.springboot.jpaDemo.com.springboot.jpaDemo.dao.CatDao;
import com.springboot.jpaDemo.com.springboot.jpaDemo.repository.CatRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/3/17.
 */
@Service
public class CatService {
    @Resource
    private CatRepository catRepository;
    @Resource
    private CatDao catDao;
    //保存数据.
    @Transactional
    public void save(Cat cat){
        catRepository.save(cat);
    }

    //删除数据》
    @Transactional
    public void delete(int id){
        catRepository.delete(id);
    }

    //查询数据.
    public Iterable<Cat> getAll(){
        return catRepository.findAll();
    }
    public Cat selectByCatName(String catName){
        return  catDao.selectByCatName(catName);
    }
}
