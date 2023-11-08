package com.company;

public class Main {

    public static void main(String[] args) {

        Tree TreeBinary = new Tree();

        TreeBinary.Add_Node("Poplavskiy","Michael","4","16354673","Man","2001");
        TreeBinary.Add_Node("Tkachenko","Olexandr","2","13456323","Man","1999");
        TreeBinary.Add_Node("Malchenko","Angelina","3","13554928","girl","2002");
        TreeBinary.Add_Node("Makarenko","Maxim","1","1356373","Man","2003");

        System.out.println("До Видалення: ");

        TreeBinary.PostOrderTraversal();

        Student Node = TreeBinary.Contains("1","Man");

        System.out.println("Пошук елемента: ");

        TreeBinary.Tree_Output(Node);

        System.out.println("Після Видалення: ");

        System.out.println(TreeBinary.Remove("2","Man"));

        TreeBinary.PostOrderTraversal();

    }
}
