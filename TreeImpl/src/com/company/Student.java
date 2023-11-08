package com.company;

public class Student
{
    Student(String s_name,String name,String Course,String ID,String sex,String dateOf_birth)
    {
        this.s_name = s_name;
        this.name = name;
        this.Course = Course;
        this.ID = ID;
        this.sex = sex;
        this.dateOf_birth = dateOf_birth;
    }

    public String s_name,name,Course,ID,dateOf_birth,sex;

    Student LeftNext;
    Student RightNext;
}
