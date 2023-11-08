package com.company;

public class Main {

    public static void main(String[] args)
    {
        List obj_list = new List();

        obj_list.Push_Node("1424");
        obj_list.Push_Node("-4");
        obj_list.Push_Node("241");
        obj_list.Push_Node("17");

        obj_list.Insert_Node("3443",2);

        System.out.println("the first data structure");



        obj_list.Output_List();

        System.out.println("\t");

        Stack stack = new Stack();

        String[] str = new String[]{"264","346","54"};

        stack.Create_Stack(str);

        System.out.println("the second data structure");

        stack.Output_List();

        System.out.println("\t");

        while(obj_list.Nextnode != null)
        {
            int tmp = Integer.parseInt(obj_list.Nextnode.value);

            for(int i = 2;i < tmp;i++)
            {
                if(tmp % i != 0)
                {
                    stack.Push_Stack(String.valueOf(tmp));
                }
                break;
            }
            obj_list.Nextnode = obj_list.Nextnode.next;
        }

        System.out.println("the second data structure");

        stack.Output_List();

    }
}
