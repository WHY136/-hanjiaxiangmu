package com.example.springbootmybatis.service;


import com.example.springbootmybatis.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;


    public String login(String username, String password){
         return loginDao.login(username,password);
    }

    public void changePassword(String username,String newPassword){
        loginDao.changePassword(username,newPassword);
    }

    public String selectPswByUser(String username){
        return loginDao.selectPswByUser(username);
    }

}
