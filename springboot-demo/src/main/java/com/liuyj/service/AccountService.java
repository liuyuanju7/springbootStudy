package com.liuyj.service;

import com.liuyj.bean.Account;
import com.liuyj.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyuanju1
 * @date 2018/4/24
 * @description:
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public int add(String name,double money){
        return accountMapper.add(name,money);
    }

    public int update(String name,double money,int id){
        return accountMapper.update(name,money,id);
    }

    public int resetMoney(double money,int id){
        return accountMapper.updateMoney(money, id);
    }

    public int delete(int id){
        return accountMapper.delete(id);
    }

    public Account findAccountById(int id){
        return accountMapper.findAccountById(id);
    }

    public List<Account> findAllAccount(){
        return accountMapper.findAllAccount();
    }
}
