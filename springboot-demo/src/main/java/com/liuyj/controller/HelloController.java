package com.liuyj.controller;

import com.liuyj.bean.Myself;
import com.liuyj.bean.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyuanju1
 * @date 2018/4/23
 * @description: 利用配置文件值注入 方式 可以实现 多环境的配置 开发 生产 测试 等
 */
@RestController
//配置类
@EnableConfigurationProperties({Myself.class})
public class HelloController {

    @Value("${my.name}")
    private String userName;
    @Value("${my.age}")
    private int age;
    @Value("${my.uid}")
    private String uid;

    @Autowired
    private Myself myself;
    @Autowired
    private Tester tester;

    @RequestMapping("/")
    public String hello(){
        return "Greeting from SpringBoot: Hello world!";
    }

//   从配置文件中 读取值 并注入
    @RequestMapping("/my")
    public String my(){
        return "配置文件直接注入：current user's name is " + userName + " and age is " + age + " uid is " + uid;
    }

//    从配置文件 注入到 bean
    @RequestMapping("/myself")
    public String myself(){
        return "配置文件注入到bean：current user's name is " + myself.getName() + " and age is " + myself.getAge() + " uid is " + myself.getUid();
    }

//    从自定义配置 注入到 bean
    @RequestMapping("/tester")
    public String tester(){
        return "自定义配置文件注入到bean：current user's name is " + tester.getName() + " and age is " + tester.getAge();
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public User get(@RequestParam String id){
//        return userService.findById(id);
//    }
}
