package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dao.MemberDao;
import com.example.springbootmybatis.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MemberService {

    @Autowired
    MemberDao memberDao;

     public List<Member> getAllMember(){
        return memberDao.getAllMember();
     }
     public Member getMemberById(int id ){
         return memberDao.getMemberById(id);
     }
     public void insertMember(Member member){
         memberDao.insertMember(member);
     }
     public  void deleteMemberById(int id){
         memberDao.deleteMemberById(id);
     }
     public  void updateMember(Member member){
         memberDao.updateMember(member);
     }

    public List<Member> getMemberByName(String memberName){
         return memberDao.getMemberByName(memberName);
    }
    public Member getMemberByStudentId(String studentId){
         return memberDao.getMemberByStuId(studentId);
    }
}
