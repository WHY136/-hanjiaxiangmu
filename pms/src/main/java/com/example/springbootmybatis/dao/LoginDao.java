package com.example.springbootmybatis.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface LoginDao {

    String  login(@Param("username") String username, @Param("password") String password);

    void changePassword(@Param("username") String username,@Param("newPassword") String newPassword);

    String selectPswByUser(@Param("username") String user);
}
