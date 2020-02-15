package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;


@Mapper
@Repository
public interface MemberDao {
    List<Member> getAllMember();

    Member getMemberById(int id);

    void insertMember(Member member);

    void deleteMemberById(int id);

    void updateMember(Member member);

    List<Member> getMemberByName(String memberName);

    Member getMemberByStuId(String studentId);

}
