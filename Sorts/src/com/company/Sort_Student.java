package com.company;

public class Sort_Student
{
    int mediana = 0;
    int i = 1;

    public void Mediana(Student[] array,int count)
    {
        if(array.length % 3 != 0)
        {
            if (count + 1 == array.length - 1)
            {
                mediana = array[count - 1].data_of_birth;
            }
        }
        else
        {
            mediana = array[count + 1].data_of_birth;
        }
        count += 3;
        Output_Mediana(i);
        i++;

        if (count < array.length)
            Mediana(array, count);
    }

    public void QuickSort(Student[] array,int low,int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Student bearing = array[middle];
        int i = low, j = high;

        while (i <= j)
        {
            while (array[i].data_of_birth < bearing.data_of_birth)
            {
                i++;
            }

            while (array[j].data_of_birth > bearing.data_of_birth)
            {
                j--;
            }

            if (i <= j)
            {
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            QuickSort(array, low, j);

        if (high > i)
            QuickSort(array, i, high);

    }

    void Output(Student[] array)
    {
        for(int i = 0;i < 12;i++)
        {
            System.out.println(array[i].Surname);
            System.out.println(array[i].name);
            System.out.println(array[i].data_of_birth);
            System.out.println("");
        }
    }

    void Output_Mediana(int count)
    {
        System.out.print("Median of three elements of group " + count + " " + mediana);
    }
}
