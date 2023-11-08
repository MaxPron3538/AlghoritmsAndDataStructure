package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Enter the size of the hashtag:");

        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        HashTableCreate Hashtable = new HashTableCreate(size);

        for(int i = 0;i < size;i++)
        {
            double x1 = Math.random() * 40;
            System.out.println(x1);
            double y1 = Math.random() * 70;
            System.out.println(y1);
            double x2 = Math.random() * 90;
            System.out.println(x2);
            double y2 = y1;
            System.out.println(y2);
            double x3 = x1;
            System.out.println(x3);
            double y3 = Math.random() * 60;
            System.out.println(y3);

            Hashtable.Add_Hashtable(x1,y1,x2,y2,x3,y3);
        }

        Hashtable.Print_HashTable();

        System.out.println("Enter the key value (Square):");

        int key = in.nextInt();

        Hashtable.Get_ElemHashtable(key);

        System.out.println("Enter a parameter value to delete items whose perimeters are larger than specified:");

        int perim = in.nextInt();

        System.out.println("Enter the key value (Square):");

        key = in.nextInt();

        Hashtable.Del_HashTable(perim,key);

        Hashtable.Print_HashTable();

        in.close();
    }
}
