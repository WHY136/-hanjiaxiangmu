package com.example.springbootmybatis.controller;


import com.example.springbootmybatis.model.Member;
import com.example.springbootmybatis.service.MemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/members")
    public String toListPage(ModelMap modelMap,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum,7);
        List<Member> list = memberService.getAllMember();
        PageInfo<Member> pageInfo = new PageInfo<>(list);
        modelMap.addAttribute("pageInfo",pageInfo);
        return "member/list";
    }
    //跳转到添加页面。
    @GetMapping("/add")
    public String toAddPage(){
        return "member/add";
    }

    //对应添加页面表单的提交
    @PostMapping("/add")
    public String insertMember(Member member){
        memberService.insertMember(member);
        System.out.println("add:"+member.toString());
        return "redirect:/members";
    }

    //跳转到update页面
    @RequestMapping("/update/{id}")
    public String toUpdatePage(@PathVariable("id") int id,Model model){
        Member member = memberService.getMemberById(id);
        model.addAttribute("member",member);
        return "member/update";
    }
    //对应update页面表单提交
    @PostMapping("/update")
    public String updateMember(@ModelAttribute Member member){
        memberService.updateMember(member);
        System.out.println("修改的："+member.toString());
        return "redirect:/members";
    }

    //删除，跳转list页面
    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable("id") int id){
        memberService.deleteMemberById(id);
        return "redirect:/members";
    }

    //到填写信息页面
    @GetMapping("/memInfo")
    public String toInfoPage(){
        return "member/memInfo";
    }
    //填写表单，更新到数据库
    @PostMapping("/memInfo")
    public String memInfo(Member member){
        memberService.insertMember(member);
        return "redirect:/homgPage";
    }


    //到主页
    @GetMapping("/homePage")
    public String toHomePage(){
        return "homePage";
    }
    //搜索栏
    @RequestMapping(value = "/search",method = {RequestMethod.GET,RequestMethod.POST})
    public String search(HttpServletRequest request, Model model){
        String memberName = request.getParameter("memberName");
        List<Member> members2 = memberService.getMemberByName(memberName);

        for (Member member2:members2) {
            if(member2 == null){
                return "error/search";
            }
            System.out.println("search"+member2.toString());
        }
        model.addAttribute("members2",members2);
        return "member/memDetails";
    }

    @RequestMapping(value = "/search1",method = {RequestMethod.GET,RequestMethod.POST})
    public String search1(HttpServletRequest request, Model model){
        String studentId = request.getParameter("studentId");
        Member member1 = memberService.getMemberByStudentId(studentId);

            if(member1 == null){
                return "error/search";
            }
            System.out.println("search"+member1.toString());
        model.addAttribute("member1",member1);
        return "member/memDetails1";
    }
}