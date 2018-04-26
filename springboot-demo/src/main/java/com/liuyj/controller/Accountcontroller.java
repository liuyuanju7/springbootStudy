package com.liuyj.controller;

import com.liuyj.bean.Account;
import com.liuyj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuyuanju1
 * @date 2018/4/24
 * @description: RESTful API demo
 * spring4.3中引进了｛@GetMapping、@PostMapping、@PutMapping、@DeleteMapping、@PatchMapping｝，
 * 来帮助简化常用的HTTP方法的映射，并更好地表达被注解方法的语义
 */
//该注解相当于 在每个方法前 添加 @ResponseBody
@RestController
@RequestMapping("/account")
public class Accountcontroller {

    @Autowired
    private AccountService accountService;

    //POST 新建资源
    @RequestMapping(value="",method = RequestMethod.POST)
    public String addAccount(@RequestParam String name,@RequestParam double money){
        int row = accountService.add(name,money);
        return row > 0 ? "success" : "fail";
    }

    // DELETE 删除资源
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public String delAccount(@PathVariable int id){
        int row = accountService.delete(id);
        return row > 0 ? "success" : "fail";
    }

    //PUT 修改资源
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateAccount(@PathVariable int id,@RequestParam String name,@RequestParam double money){
        int row = accountService.update(name,money,id);
        return row > 0 ? "success" : "fail";
    }

    //PATCH 修改资源 部分信息
    @RequestMapping(value = "/{id}",method = RequestMethod.PATCH)
    public String updateAccountByPatch(@PathVariable int id,@RequestParam double money){
        int row = accountService.resetMoney(money,id);
        return row > 0 ? "success" : "fail";
    }

    // GET 获取资源
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account getAccountById(@PathVariable int id){
        return accountService.findAccountById(id);
    }
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<Account> getAccountList(){
        return accountService.findAllAccount();
    }
}
