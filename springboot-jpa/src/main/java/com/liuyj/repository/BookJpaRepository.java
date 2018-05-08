package com.liuyj.repository;

import com.liuyj.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author liuyuanju1
 * @date 2018/4/26
 * @description:
 */
public interface BookJpaRepository extends JpaRepository<Book,Integer>{
    List<Book> findBooksByDesNotNull();

    /** 自定义查询sql 使用@Query注解*/
    //这里的 Book 是注解实体类的 类名 各字段也是 实体类的属性 所以 不能用 select *
    //sql 参数 占位符 ?1  ?2
    @Query(value = "select name,price,des from Book b where b.price > ?1 and b.price < ?2")
    List<Book> findByPriceRange(double price1,double price2);

    // :xx  占位符
    @Query(value = "select name,price,des from Book b where b.name like concat('%',:name,'%')")
    List<Book> findBookByNameLike(@Param("name") String name);

    //使用 Native SQL Query
    //所谓本地查询，就是使用原生的sql语句进行查询数据库的操作
    // 因为是 原生sql 所以 表名 要写 真正的数据库表
    @Query(value = "select * from book where id = :id",nativeQuery = true)
    Book findByQueryId(@Param("id")Integer id);

}
