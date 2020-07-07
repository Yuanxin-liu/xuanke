package com.xuanke1.dao;

import com.xuanke1.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from user")
    public List<User> getUsers();

    @Select("select * from user where username=#{username}")
    public  User getUserByMessage(@Param("username") String username);

}
