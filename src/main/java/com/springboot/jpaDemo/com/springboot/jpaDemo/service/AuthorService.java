package com.springboot.jpaDemo.com.springboot.jpaDemo.service;

import com.springboot.jpaDemo.com.springboot.jpaDemo.bean.Author;

import java.util.List;

/**
 * Created by 墨殇 on 2017/6/27.
 */
public interface AuthorService {

    public int add(Author author);
    public int update(Author author);
    public int delete(Long id);
    public Author findAuthor(Long id);
    public List<Author> findAuthorList();
}
