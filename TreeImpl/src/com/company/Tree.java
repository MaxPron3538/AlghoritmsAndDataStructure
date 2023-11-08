package com.company;
import org.w3c.dom.Node;

public class Tree
{
    void Add_Node(String s_name, String name, String Course, String ID, String sex, String dateOf_birth)
    {
        if (Head == null)
        {
            Head = new Student(s_name, name, Course, ID, sex, dateOf_birth);
        }
        else if (Head != null)
        {
            Add_AtTheEnd(Head, s_name, name, Course, ID, sex, dateOf_birth);
        }
        count++;
    }

    void Add_AtTheEnd(Student Node, String s_name, String name, String Course, String ID, String sex, String dateOf_birth)
    {
        if (dateOf_birth.compareTo(Node.dateOf_birth) < 0)
        {
            if (Node.LeftNext == null)
            {
                Node.LeftNext = new Student(s_name, name, Course, ID, sex, dateOf_birth);
            }
            else
            {
                Node = Node.LeftNext;
                Add_AtTheEnd(Node, s_name, name, Course, ID, sex, dateOf_birth);
            }
        }
        else if (dateOf_birth.compareTo(Node.dateOf_birth) > 0)
        {
            if (Node.RightNext == null)
            {
                Node.RightNext = new Student(s_name, name, Course, ID, sex, dateOf_birth);
            }
            else
            {
                Node = Node.RightNext;
                Add_AtTheEnd(Node, s_name, name, Course, ID, sex, dateOf_birth);
            }
        }
    }

    public Student Contains(String Course, String sex)
    {
        Student parent = null;
        return FindForRemove(Course, sex, parent,0);
    }

    public Student FindForRemove(String Course,String sex,Student parent,int num)
    {
        Student current = Head;
        parent = null;

        String data_of_birth = "2004";

        while(current != null)
        {
            int result1 = current.sex.compareTo("Man");
            int result2 = current.Course.compareTo("1");
            int result3 = current.dateOf_birth.compareTo(data_of_birth);


            if (result3 > 0 && (result1 != 0 && result2 != 0) || (result1 != 0 || result2 != 0))
            {
                parent = current;
                current = current.LeftNext;
            }
            else if (result3 < 0 && (result1 != 0 && result2 != 0) || (result1 != 0 || result2 != 0))
            {
                parent = current;
                current = current.RightNext;
            }
            else
            {
                break;
            }
        }
        if(num == 1) return parent;

        return current;
    }

    public boolean Remove(String Course,String sex)
    {
        Student parent = FindForRemove(Course,sex,null,1);
        Student current = FindForRemove(Course,sex,parent,0);

        if (current == null)
        {
            return false;
        }
        count--;

        if(parent == null)
        {
            if(current.RightNext == null )

            current = Head.LeftNext;

            else current = Head.RightNext;
        }
        else
        {
            if (parent.dateOf_birth.compareTo(current.dateOf_birth) > 0)
            {
                if (current.LeftNext != null && current.LeftNext.RightNext != null)
                {
                    parent.LeftNext = current.LeftNext.RightNext;
                }
                else if (current.LeftNext != null && current.LeftNext.RightNext == null)
                {
                    parent.LeftNext = current.RightNext;
                }
                else
                {
                    parent.LeftNext = current.LeftNext;
                }
            }
            else if (parent.dateOf_birth.compareTo(current.dateOf_birth) < 0)
            {
                if (current.RightNext != null && current.RightNext.LeftNext != null)
                {
                    parent.RightNext = current.RightNext.LeftNext;
                }
                else if (current.RightNext != null && current.RightNext.LeftNext == null)
                {
                    parent.RightNext = current.LeftNext;
                }
                else
                {
                    parent.RightNext = current.RightNext;
                }
            }
        }
        return true;
    }

    public void PostOrderTraversal()
    {
        PostOrderTraversal_Output(Head);
    }

    private void PostOrderTraversal_Output(Student node)
    {
        if (node != null)
        {
            PostOrderTraversal_Output(node.LeftNext);
            PostOrderTraversal_Output(node.RightNext);

            Tree_Output(node);
        }
    }

    public void Tree_Output(Student node)
    {
        System.out.print("Surname = ");
        System.out.println(node.s_name);
        System.out.print("Name = ");
        System.out.println(node.name);
        System.out.print("Course = ");
        System.out.println(node.Course);
        System.out.print("ID = ");
        System.out.println(node.ID);
        System.out.print("Data of birth = ");
        System.out.println(node.dateOf_birth);
        System.out.print("sex = ");
        System.out.println(node.sex);
        System.out.println("");
    }

    public Student Head;
    int value = 0;
    public int count = 0;

}

