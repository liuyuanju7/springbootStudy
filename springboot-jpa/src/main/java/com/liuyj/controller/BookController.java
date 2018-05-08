package com.liuyj.controller;

import com.liuyj.entity.Book;
import com.liuyj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping(value= "/list/{name}")
    public List<Book> findBooksLikeName(@PathVariable String name){
        return bookService.findBooksByName(name);
    }

    @GetMapping(value = "/list")
    public List<Book> findAllBook(){
        return bookService.findAllBooks();
    }

    // JPA Controller
    /**
     *
     * @param page 第几页  起始页 0
     * @param size 每页 页数
     * @return
     */
    @GetMapping(value="")
    public Page<Book> findBookByPage(int page,int size){
        Page<Book> pages = bookService.findAllByPage(page,size);
        // pages.getContent(); 对应数据实体
        return pages;
    }

    @GetMapping(value="")
    public List<Book> findBooksByDesNotNull(){
        return bookService.findBooksByDesNotNull();
    }

    @RequestMapping(value="")
    public List<Book> findByPriceRange(double price1,double price2){
        return bookService.findByPriceRange(price1,price2);
    }

    @RequestMapping(value = "/{name}")
    public List<Book> findBookByNameLike(@PathVariable String name){
        return bookService.findBookByNameLike(name);
    }

    @GetMapping(value = "")
    public Book findByQueryId(Integer id){
        return bookService.findByQueryId(id);
    }

}
