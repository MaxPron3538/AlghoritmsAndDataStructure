package com.company;
import  java.util.*;

public class Node_Student implements Comparable
{
    Node_Student(String s_name,String sex,String reader_ticket_number,String ticket_validity_date)
    {
        this.s_name = s_name;
        this.sex = sex;
        this.reader_ticket_number = reader_ticket_number;
        this.ticket_validity_date = ticket_validity_date;
    }

    public String s_name,sex,reader_ticket_number,ticket_validity_date;

    Node_Student LeftNext;
    Node_Student RightNext;


    public int compareTo(Object obj)
    {
        Node_Student tmp = (Node_Student)obj;

        if(this.ticket_validity_date.compareTo(((Node_Student) obj).ticket_validity_date) < 0)
        {
           return -1;
        }
        else if(this.ticket_validity_date.compareTo(tmp.ticket_validity_date) > 0)
        {
           return 1;
        }

        return 0;
    }
}
