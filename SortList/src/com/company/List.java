package com.company;

class Node
{
    Node(String value)
    {
        this.value = value;
        next = null;
    }
    public int count;
    public String value;
    Node next;
}

public class List
{
    public Node Nextnode;
    public Node Current;
    int count = 0;

    public void Push_Node(String value)
    {
        if (Nextnode == null)
        {
            Nextnode = new Node(value);
            Nextnode.count = count;
            count++;
        } else {

            Current = Nextnode;

            while (Current.next != null)
            {
                Current = Current.next;
            }

            Current.next = new Node(value);
            Current.next.count = count;
            count++;
        }

    }

    public void Insert_Node(String value, int number)
    {
        Node previously = null;
        Node current = Nextnode;

        while (current != null)
        {
            if (current.count == number)
            {
                if (previously == null)
                {
                    Node new_node = new Node(value);
                    current = new_node;

                }
                else if (previously != null)
                {
                    Node new_node = new Node(value);
                    if(current.next != null)
                    {
                        Node NextCurrent = current.next;
                        current = new_node;
                        current.next = NextCurrent;

                    }
                    current = new_node;
                    previously.next = current;
                }
            }
            previously = current;
            current = current.next;
        }

    }

    public boolean Remove_Node(String value)
    {
        Node current = Nextnode;
        Node previous = null;

        while (current != null)
        {
            if (current.value.equals(value))
            {
                if (previous != null)
                {
                    if (current.next == null)
                    {
                        Current = previous;

                    } else{

                        previous.next = current.next;
                    }

                } else {

                    Nextnode = Nextnode.next;

                    if (Nextnode == null)
                    {
                        this.Current = null;
                    }
                }

                count--;
                return true;
            }

            previous = current;
            current = current.next;

        }
        return false;
    }

    public Node[] Array_List()
    {
        Node[] array = new Node[count];
        Node current = Nextnode;
        int index = 0;

        while(current != null)
        {
            array[index] = new Node(current.value);
            current = current.next;
            index++;
        }
    return array;
    }

    public void Clear()
    {
        Nextnode = null;
        Current = null;
        count = 0;
    }

    void Output_List()
    {
        Node current = Nextnode;

        while(current != null)
        {
            System.out.println(current.value);

            current = current.next;
        }
    }
}
