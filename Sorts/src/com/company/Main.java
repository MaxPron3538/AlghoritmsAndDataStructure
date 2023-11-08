package com.company;
public class Main {

    public static void main(String[] args) {

        Student[] array = new Student[12];

        array[0] = new Student("Tkachenko","Olexandr",2002);
        array[1] = new Student("Pron","Maxim",1999);
        array[2] = new Student("Zarova","Tanya",2000);
        array[3] = new Student("Antonov","Kostya",1998);
        array[4] = new Student("Sergeev","Dmitriy",1996);
        array[5] = new Student("Lomonosov","Viktor",1997);
        array[6] = new Student("Bondarenko","Katya",1995);
        array[7] = new Student("Stalin","Iosif",1888);
        array[8] = new Student("Lenin","Vladimir",1872);
        array[9] = new Student("Gagarin","Yuriy",1943);
        array[10] = new Student("Mask","Ilon",1984);
        array[11] = new Student("Geits","Bill",1968);

        Sort_Student sortStudent = new Sort_Student();

        sortStudent.QuickSort(array,0,11);

        sortStudent.Output(array);

        sortStudent.Mediana(array,0);

    }
}
