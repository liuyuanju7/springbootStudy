package com.liuyj.repository;

import com.liuyj.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author liuyuanju1
 * @date 2018/4/25
 * @description:注意 CrudRepository 各个方法中的返回值, CrudRepository 是基本的增删改查方法
 */
public interface BookRepository extends CrudRepository<Book,Integer> {
    /**
     *  根据 spring data jpa 的命名规范 不用自己实现 jpa 即可自动转化 底层的查询
    */
    Book findBookByName(String name);

    /**
     * Like 的 模糊查询  where name like '%?%'
     * @param name
     * @return
     */
    List<Book> findBooksByNameContaining(String name);
}

