package com.example.springbootmybatis.model;


public class Member {
    private int id;
    private String memberName;
    private String studentId;
    private String college;
    private String major;
    private String qq;
    //1表示男，0表示女
    private int gender;
    private String workRecord;
    private String clothSize;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", qq='" + qq + '\'' +
                ", gender=" + gender +
                ", workRecord='" + workRecord + '\'' +
                ", clothSize='" + clothSize + '\'' +
                '}';
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getWorkRecord() {
        return workRecord;
    }

    public void setWorkRecord(String workRecord) {
        this.workRecord = workRecord;
    }

    public String getClothSize() {
        return clothSize;
    }

    public void setClothSize(String clothSize) {
        this.clothSize = clothSize;
    }
}
