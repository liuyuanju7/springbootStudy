package com.liuyj.dao;

import com.liuyj.bean.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuyuanju1
 * @date 2018/4/24
 * @description: 利用注解方式 整合mybatis dao
 */
@Mapper
@Repository
public interface AccountMapper {

    @Insert("insert into account(name,money) values(#{name},#{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name = #{name},money=#{money} where id = #{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int id);

    @Update("update account set money = #{money} where id = #{id}")
    int updateMoney(@Param("money") double mooney, @Param("id") int id);

    @Delete("delete from account where id = #{id}")
    int delete(@Param("id") int id);

    @Select("select id, name, money from account where id = #{id}")
    Account findAccountById(@Param("id") int id);

    @Select("select id, name, money from account")
    List<Account> findAllAccount();
}
