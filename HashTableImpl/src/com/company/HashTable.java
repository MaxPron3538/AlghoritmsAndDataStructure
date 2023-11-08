package com.company;

public class HashTable
{
    public int size;
    List[] table;
}

class HashTableCreate
{
    HashTableCreate(int size)
    {
        hashTable = new HashTable();
        hashTable.table = new List[size];
        hashTable.size = size;

        for(int i = 0;i < hashTable.size;i++)
        {
            hashTable.table[i] = new List();
        }
    }
    public HashTable Add_Hashtable(double X1,double Y1,double X2,double Y2,double X3,double Y3)
    {
        int key = Square_key(X1,Y1,X2,Y2,X3,Y3);

        hash = Multiplication_Hash(key,hashTable.size);
        hashTable.table[hash].Push_Node(X1,Y1,X2,Y2,X3,Y3,key,hash);

        return hashTable;
    }

    public HashTable Get_ElemHashtable(int key)
    {
        hash = Multiplication_Hash(key,hashTable.size);
        hashTable.table[hash].Output_List();

        return hashTable;
    }

    public void Print_HashTable()
    {
       for(int i = 0;i < hashTable.size;i++)
       {
           NodeRectangle current = hashTable.table[i].Nextnode;

           if(current == null) { continue; }

           hashTable.table[i].Output_List();
       }
    }
    public void Del_HashTable(int perim,int key)
    {
        hash = Multiplication_Hash(key, hashTable.size);
        hashTable.table[hash].Remove_Node(perim);
    }

    public int Square_key(double X1,double Y1,double X2,double Y2,double X3,double Y3)
    {
        int val1,val2;

        val1 = (int)Math.sqrt((X2 - X1)*(X2 - X1)+(Y2 - Y1)*(Y2 - Y1));
        val2 = (int)Math.sqrt((X3 - X1)*(X3 - X1)+(Y3 - Y1)*(Y3 - Y1));

        return val1 * val2;
    }

    public double fMod(double a,double b) { return a % b; }

    int Multiplication_Hash(int key,int size)
    {
       double A = 0.6180339887;

       return ((int) (size * fMod(A * key, 1)));
    }

    public HashTable hashTable;
    private int hash;
}