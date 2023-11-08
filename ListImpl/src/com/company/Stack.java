package com.company;

class S_Node
{
    S_Node(String str)
    {
        this.str = str;
        next = null;
    }

    public String str;
    S_Node next;
    int count;

}

public class Stack
{
   public S_Node Unit;
   public S_Node Current;

   int count = 0;

   void Create_Stack(String[] str)
   {
      int i = 0;

      while(i < str.length)
      {
          if(Unit == null)
          {
            Unit = new S_Node(str[i]);
            Unit.count = count;
            count++;
          }
          else
          {
            Current = Unit;

            while (Current.next != null)
            {
                  Current = Current.next;
            }

            Current.next = new S_Node(str[i]);
            Current.next.count = count;
            count++;
          }
          i++;
      }
   }

   void Push_Stack(String str)
   {
       S_Node current = Unit;

       while (current.next != null)
       {
           current = current.next;

           if(current.next == null)
           {
               current.next = new S_Node(str);
               current = current.next;
               current.count = count;
               count++;
           }
       }
   }

   boolean Remove_S_Node(String str)
   {
       S_Node previous = null;
       S_Node current = Unit;

       while(current != null)
       {
           if(current.str.equals(str))
           {
               if(current.next == null)
               {
                   current = previous;

                   return true;
               }

               previous = current;
               current = current.next;
           }

       }
       return false;
   }

    public void Clear()
    {
        Unit = null;
        Current = null;
        count = 0;
    }

   void Output_List()
   {
     S_Node current = Unit;

     while(current != null)
     {
         System.out.println(current.str);

         current = current.next;
     }
   }

}
