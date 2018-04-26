package com.liuyj.entity;

import javax.persistence.*;

/**
 * @author liuyuanju1
 * @date 2018/4/25
 * @description: springboot 整合 spring data jpa
 */
@Entity
public class Book {

    @Id
    //设置主键自增策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "price")
    private double price;

    @Column
    private String des;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
