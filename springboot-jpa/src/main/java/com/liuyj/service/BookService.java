package com.liuyj.service;

import com.liuyj.entity.Book;

import java.util.List;

/**
 * @author liuyuanju1
 * @date 2018/4/25
 * @description:
 */
public interface BookService {

    Book save(Book book);

    void delete(int id);

    Book findById(int id);

    Book findByName(String name);

    List<Book> findAllBooks();

}
