package com.company;

class NodeRectangle
{
    NodeRectangle(double X1,double Y1,double X2,double Y2,double X3,double Y3,int key,int hash)
    {
        this.val1 = Math.sqrt((X2 - X1)*(X2 - X1)+(Y2 - Y1)*(Y2 - Y1));
        this.val2 = Math.sqrt((X3 - X1)*(X3 - X1)+(Y3 - Y1)*(Y3 - Y1));
        this.key = key;
        this.hash = hash;
        next = null;
    }

    int Square_Rectangle() { return key; }

    int Perimeter_Rectangle()
    {
        perim = (int)(val1 * 2 + val2 * 2);

    return perim;
    }

    void Output_Object()
    {
        System.out.print("The Position of the Node is ");
        System.out.println(hash);
        System.out.print("The Height of the Rectangle is ");
        System.out.println(val1);
        System.out.print("The Weight of the Rectangle is ");
        System.out.println(val2);
        System.out.print("The Square of the Rectangle is ");
        System.out.println(Square_Rectangle());
        System.out.print("The Perimeter of the Rectangle is ");
        System.out.println(Perimeter_Rectangle());
        System.out.println("");
    }

    int count;
    public int key,hash,perim;
    double val1,val2;
    NodeRectangle next;
}

public class List
{
    public NodeRectangle Nextnode,Current;
    int count = 0,val1,val2;

    public void Push_Node(double X1,double Y1,double X2,double Y2,double X3,double Y3,int key,int hash)
    {
        if (Nextnode == null)
        {
            Nextnode = new NodeRectangle(X1,Y1,X2,Y2,X3,Y3,key,hash);
            Nextnode.count = count;
            count++;

        } else {

            Current = Nextnode;

            while (Current.next != null)
            {
                Current = Current.next;
            }
            Current.next = new NodeRectangle(X1,Y1,X2,Y2,X3,Y3,key,hash);
            Current.next.count = count;
            count++;
        }
    }

    public void Insert_Node(double X1,double Y1,double X2,double Y2,double X3,double Y3,int key,int hash,int number)
    {
        NodeRectangle previously = null;
        NodeRectangle current = Nextnode;

        while (current != null)
        {
            if (current.count == number)
            {
                if (previously == null)
                {
                    NodeRectangle new_node = new NodeRectangle(X1,Y1,X2,Y2,X3,Y3,key,hash);
                    current = new_node;
                }
                else if (previously != null)
                {
                    NodeRectangle new_node = new NodeRectangle(X1,Y1,X2,Y2,X3,Y3,key,hash);

                    if(current.next != null)
                    {
                        NodeRectangle CurrentNext = current.next;
                        current = new_node;
                        current.next = CurrentNext;
                    }
                    current = new_node;
                    previously.next = current;
                }
            }
            previously = current;
            current = current.next;
        }

    }

    public boolean Remove_Node(int perim)
    {
        NodeRectangle current = Nextnode;
        NodeRectangle previous = null;

        while (current != null)
        {
            if (current.perim > perim)
            {

                if (previous != null)
                {
                    if (current.next == null)
                    {
                        Current = previous;
                        current = Current;
                    } else {
                        previous.next = current.next;
                    }
                } else {
                    Nextnode = Nextnode.next;
                    current = Nextnode;

                    if (Nextnode == null)
                    {
                        this.Current = null;
                    }
                }
                continue;
            }
            previous = current;
            current = current.next;
            count--;
        }
        return false;
    }

    public void Clear()
    {
        Nextnode = null;
        Current = null;
        count = 0;
    }

    void Output_List()
    {
        NodeRectangle current = Nextnode;

        while(current != null)
        {
            current.Output_Object();

            current = current.next;
        }
    }



}
