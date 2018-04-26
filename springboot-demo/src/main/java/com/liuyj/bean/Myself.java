package com.liuyj.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuyuanju1
 * @date 2018/4/23
 * @description: 测试配置文件的属性 赋给 实体类
 */
//@ConfigurationProperties 需要 引入spring-boot-configuration-processor
@ConfigurationProperties(prefix = "my")
@Component
public class Myself {
    private String uid;
    private String name;
    private int age;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

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
