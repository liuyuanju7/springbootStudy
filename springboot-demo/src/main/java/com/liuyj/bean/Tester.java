package com.liuyj.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author liuyuanju1
 * @date 2018/4/23
 * @description: 引入自定义配置文件 注入到 bean
 */
@Configuration
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "test")
public class Tester {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
