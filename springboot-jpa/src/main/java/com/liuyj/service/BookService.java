package com.liuyj.service;

import com.liuyj.entity.Book;
import org.springframework.data.domain.Page;

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

    List<Book> findBooksByName(String name);

    //JPA Repository

    Page<Book> findAllByPage(int page,int size);

    List<Book> findBooksByDesNotNull();

    //自定义@Query 查询
    List<Book> findByPriceRange(double price1,double price2);

    List<Book> findBookByNameLike(String name);

    Book findByQueryId(Integer id);
}
