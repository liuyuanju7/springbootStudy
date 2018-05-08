package com.liuyj.service.impl;

import com.liuyj.entity.Book;
import com.liuyj.repository.BookJpaRepository;
import com.liuyj.repository.BookRepository;
import com.liuyj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author liuyuanju1
 * @date 2018/4/25
 * @description:
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookJpaRepository jpaRepository;

    //保存 或 修改
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }


    @Override
    public Book findById(int id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId.get();
    }

    @Override
    public Book findByName(String name) {
        return bookRepository.findBookByName(name);
    }

    @Override
    public List<Book> findAllBooks() {
        return (List<Book>)bookRepository.findAll();
    }

    @Override
    public List<Book> findBooksByName(String name) {
        return bookRepository.findBooksByNameContaining(name);
    }

    //JPA Repository
    @Override
    public Page<Book> findAllByPage(int page, int size) {
        Sort sort = new Sort(Sort.Direction.ASC,"id");
      //不带排序  jpaRepository.findAll(new PageRequest(page,size));
        return jpaRepository.findAll(new PageRequest(page,size,sort));
    }

    @Override
    public List<Book> findBooksByDesNotNull() {
        return jpaRepository.findBooksByDesNotNull();
    }

    @Override
    public List<Book> findByPriceRange(double price1, double price2) {
        return jpaRepository.findByPriceRange(price1,price2);
    }

    @Override
    public List<Book> findBookByNameLike(String name) {
        return jpaRepository.findBookByNameLike(name);
    }

    @Override
    public Book findByQueryId(Integer id) {
        return jpaRepository.findByQueryId(id);
    }


}
