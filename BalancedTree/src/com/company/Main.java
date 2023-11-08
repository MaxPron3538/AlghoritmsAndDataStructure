package com.company;

public class Main {

    public static void main(String[] args)
    {
        Tree TreeBinary = new Tree();

        TreeBinary.Add_Node("Poplavskiy","Man","16354673","2020","End");
        TreeBinary.Add_Node("Tkachenko","Man","13456323","2021","End");
        TreeBinary.Add_Node("Kvitchenko","Man","1356373","2022","End");
        TreeBinary.Add_Node("Bondar","girl","13554928","2018","First");
        TreeBinary.Add_Node("Antipova","girl","14554682","2019","First");

        System.out.println("До Видалення: ");

        TreeBinary.PostOrderTraversal();

        Node_Student Node = TreeBinary.Contains("Kvitchenko");

        System.out.println("Пошук елемента: ");

        TreeBinary.Tree_Output(Node);

        System.out.println("Після Видалення: ");

        System.out.println(TreeBinary.Remove("Tkachenko"));

        TreeBinary.PostOrderTraversal();

        System.out.println("Інтерполяційний пошук елемента: ");

        Node = TreeBinary.InterpolationSearch("2018");

        TreeBinary.Tree_Output(Node);

        System.out.println(TreeBinary.Ticket_Validity("13554928"));
    }
}
