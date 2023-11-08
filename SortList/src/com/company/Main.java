package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        List obj_list = new List();
        int i = 0;

        while(i < 100)
        {
            double random = Math.random() * (100 - 1) + 1;
            obj_list.Push_Node(Integer.toString((int)random));
            i++;
        }

        Selection_Sort Object = new Selection_Sort();

        System.out.println("\t");

        System.out.println("the first data structure");

        System.out.println("\t");

        Object.Sort(obj_list.Array_List());

        Node[] array = new Node[obj_list.count];

        System.out.println("the second data structure");

        for (int j = 0;j < obj_list.count;j++)
        {
           double random = Math.random() * (100 - 1) + 1;
           array[j] = new Node(Integer.toString((int)random));
        }
        Object.Sort(array);

    }

}
