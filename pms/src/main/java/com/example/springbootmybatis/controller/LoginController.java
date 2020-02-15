package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录
    @RequestMapping(value = "/loginPage",method = {RequestMethod.POST,RequestMethod.GET})
    public String loginCon(HttpServletRequest request,
                           HttpSession session,
                           Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = loginService.login(username,password);
        session.setAttribute("name",name);
        if(name == null){
            map.put("message","用户名或密码错误");
            return "login";
        }
        return "redirect:/dashboard";
    }

    //修改密码
    @PostMapping( "/changePswPage")
    public String change(HttpServletRequest request,
                         Map<String ,Object> map){
        String username = request.getParameter("username");
        String password = loginService.selectPswByUser(username);
        String newPassword1 = request.getParameter("newPassword1");
        String newPassword2 = request.getParameter("newPassword2");
        if(password==null||newPassword1==null||newPassword2==null){
            map.put("message1","密码不能为空");
            return "redirect:/changePassword";
        }
        if(!password.equals(request.getParameter("oldPassword"))){
           map.put("message1","原密码错误");
            return "redirect:/changePassword";
        }
        if(!request.getParameter("newPassword1").equals(request.getParameter("newPassword2"))){
            map.put("message1","确认密码与原始密码不一致");
            return "redirect:/changePassword";
        }
        loginService.changePassword(username,request.getParameter("newPassword1"));
        return "redirect:/";
    }
}