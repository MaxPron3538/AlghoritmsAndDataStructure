package com.company;
import org.w3c.dom.Node;
import java.util.*;

public class Tree
{
    void Add_Node(String s_name,String sex,String reader_ticket_number,String ticket_validity_date,String str)
    {
        if (Head == null)
        {
            Head = new Node_Student(s_name,sex,reader_ticket_number,ticket_validity_date);
            vector.add(Head);
        }
        else if (Head != null)
        {
            if(str == "First")
                Add_AtTheFirst(Head, s_name, sex, reader_ticket_number, ticket_validity_date);
            else if(str == "End")
                Add_AtTheEnd(Head,s_name,sex,reader_ticket_number,ticket_validity_date);
        }
        count++;
    }

    void Add_AtTheFirst(Node_Student Node,String s_name,String sex,String reader_ticket_number,String ticket_validity_date)
    {
        Node_Student Root;

        if (s_name.compareTo(Node.s_name) < 0)
        {
            Root = new Node_Student(s_name, sex, reader_ticket_number, ticket_validity_date);
            Root.RightNext = Node;
            Head = Root;
            vector.add(Root);
        }
        else if (s_name.compareTo(Node.s_name) > 0)
        {
            Root = new Node_Student(s_name, sex, reader_ticket_number, ticket_validity_date);
            Root.LeftNext = Node;
            Head = Root;
            vector.add(Root);
        }
    }

    void Add_AtTheEnd(Node_Student Node,String s_name,String sex,String reader_ticket_number,String ticket_validity_date)
    {
        if (s_name.compareTo(Node.s_name) < 0)
        {
            if (Node.LeftNext == null)
            {
                Node.LeftNext = new Node_Student(s_name, sex, reader_ticket_number, ticket_validity_date);
                vector.add(Node.LeftNext);

            }
            else
                Add_AtTheEnd(Node.LeftNext, s_name, sex, reader_ticket_number, ticket_validity_date);
        }
        else if (s_name.compareTo(Node.s_name) > 0)
        {
            if (Node.RightNext == null)
            {
                Node.RightNext = new Node_Student(s_name, sex, reader_ticket_number, ticket_validity_date);
                vector.add(Node.RightNext);
            }
            else
                Add_AtTheEnd(Node.RightNext, s_name, sex, reader_ticket_number, ticket_validity_date);
        }
    }

    public Node_Student Contains(String s_name)
    {
       Node_Student parent = null;
       return FindForRemove(s_name,parent,0);
    }

    public  Node_Student FindForRemove(String s_name,Node_Student parent,int i)
    {
        Node_Student current = Head;
        parent = null;

        while (current != null)
        {
          int result = current.s_name.compareTo(s_name);

          if (result > 0)
          {
             parent = current;
             current = current.LeftNext;
          }
          else if (result < 0)
          {
             parent = current;
             current = current.RightNext;
          }
          else
          {
            break;
          }
        }
        if(i == 1) return parent;
        return current;
    }

    public Node_Student InterpolationSearch(String elementToSearch)
    {
        Node_Student[] array = new Node_Student[count];

        for(int i = 0;i < count;i++)
            array[i] = vector.get(i);

        Arrays.sort(array);

        int startIndex = 0;
        int lastIndex = (array.length - 1);

        while ((startIndex <= lastIndex) && (elementToSearch.compareTo(array[startIndex].ticket_validity_date) >= 0) && (elementToSearch.compareTo(array[lastIndex].ticket_validity_date) <= 0))
        {
           int pos = startIndex + (((lastIndex-startIndex)/(Integer.parseInt(array[lastIndex].ticket_validity_date) - Integer.parseInt(array[startIndex].ticket_validity_date))*(Integer.parseInt(elementToSearch) - Integer.parseInt(array[startIndex].ticket_validity_date))));

           if (array[pos].ticket_validity_date == elementToSearch)
           return array[pos];

           if (array[pos].ticket_validity_date.compareTo(elementToSearch) < 0)
           startIndex = pos + 1;
           else
           lastIndex = pos - 1;
        }
        return null;
    }

    public boolean Ticket_Validity(String reader_ticket_number)
    {
        for (int i = 0;i < vector.size();i++)
        {
           if(vector.get(i).reader_ticket_number == reader_ticket_number)
           {
             if(vector.get(i).sex == "Man")
             {
                 if (vector.get(i).ticket_validity_date.compareTo("2020") < 0)
                     return true;
             }
             else
                return false;
           }
        }
        return false;
    }

    public boolean Remove(String s_name)
    {
       Node_Student parent = FindForRemove(s_name,null,1);
       Node_Student current = FindForRemove(s_name,parent,0);

       if (current == null)
          return false;

       count--;

        if(parent == null)
        {
           if(current.RightNext == null)

            current = Head.LeftNext;

           else current = Head.RightNext;

        }
        else
        {
            if (parent.s_name.compareTo(current.s_name) > 0)
            {
                if (current.LeftNext != null && current.LeftNext.RightNext != null)

                    parent.LeftNext = current.LeftNext.RightNext;

                else if (current.LeftNext != null && current.LeftNext.RightNext == null)

                    parent.LeftNext = current.RightNext;

                else parent.LeftNext = current.LeftNext;
            }
            else if (parent.s_name.compareTo(current.s_name) < 0)
            {
                if (current.RightNext != null && current.RightNext.LeftNext != null)

                    parent.RightNext = current.RightNext.LeftNext;

                else if (current.RightNext != null && current.RightNext.LeftNext == null)

                    parent.RightNext = current.LeftNext;

                else
                    parent.RightNext = current.RightNext;
            }
            vector.remove(current);
            return true;
        }
       return false;
    }

    public void PostOrderTraversal()
    {
        PostOrderTraversal_Output(Head);
    }

    private void PostOrderTraversal_Output(Node_Student root)
    {
        Stack<Node_Student> stack = new Stack<Node_Student>();
        stack.push(root);

        while(!stack.isEmpty())
        {
            Node_Student node = stack.pop();

            Tree_Output(node);

            if(node.RightNext != null)
            {
                stack.push(node.RightNext);
            }
            if(node.LeftNext != null)
            {
                stack.push(node.LeftNext);
            }
        }
    }

    public void Tree_Output(Node_Student node)
    {
        System.out.println("Surname = " + node.s_name);
        System.out.println("Sex = " + node.sex);
        System.out.println("reader ticket number = " + node.reader_ticket_number);
        System.out.println("ticket validity date = " + node.ticket_validity_date);
        System.out.println("");
    }

    public Node_Student Head;
    public Vector<Node_Student> vector = new Vector<>();
    int value = 0;
    public int count = 0;
}
