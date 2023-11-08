package com.company;

public class Selection_Sort
{
    public void Output_Sort_Struct(Node[] array)
    {
        for (int i = 0; i < array.length;i++)
        {
            System.out.println("Elements " + i + "=" + array[i].value);
        }
    }

    public void Sort(Node[] array)
    {
        long startTime = System.currentTimeMillis();
        Node min;
        int minid;
        int count = 0;

            for (int index = 0; index < array.length; index++)
            {
                min = array[index];
                minid = index;

                for (int scan = index + 1; scan < array.length; scan++)
                {
                    if (array[scan].value.compareTo(min.value) < 0)
                    {
                        min = array[scan];
                        minid = scan;
                    }
                }
                Node temp = array[index];
                array[index] = min;
                array[minid] = temp;
            }
            count++;

        double stopTime = System.currentTimeMillis();

        System.out.println("Algorithm running time = " + (stopTime - startTime));
    }
}
