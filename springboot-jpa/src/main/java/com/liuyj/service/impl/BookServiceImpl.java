package com.liuyj.service.impl;

import com.liuyj.entity.Book;
import com.liuyj.repository.BookRepository;
import com.liuyj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
