package com.liuyj.controller;

import com.liuyj.entity.Book;
import com.liuyj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuyuanju1
 * @date 2018/4/25
 * @description: Springboot 整合 spring data jpa
 * spring4.3中引进了｛@GetMapping、@PostMapping、@PutMapping、@DeleteMapping、@PatchMapping｝，
 * 来帮助简化常用的HTTP方法的映射，并更好地表达被注解方法的语义
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String saveBook(String name,double price){
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        bookService.save(book);
        return "save success";
    }

    @DeleteMapping(value="/{id}")
    public String deleteBook(@PathVariable Integer id){
        bookService.delete(id);
        return "delete success";
    }

    @PutMapping(value="")
    public Book updateBook(Book book){
        return bookService.save(book);
    }

    @GetMapping(value = "/{id}")
    public Book findById(@PathVariable Integer id){
        return bookService.findById(id);
    }

    @GetMapping(value = "/{name}")
    public Book findByName(@PathVariable String name){
        return bookService.findByName(name);
    }

    @GetMapping(value = "/list")
    public List<Book> findAllBook(){
        return bookService.findAllBooks();
    }
}
