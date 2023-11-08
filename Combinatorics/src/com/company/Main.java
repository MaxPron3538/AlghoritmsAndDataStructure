package com.company;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        DefCombinatorial g = new DefCombinatorial();
        String[] elements = {
                     "Teacher1","Teacher2","Teacher3",
                     "Teacher4",//"Teacher5","Teacher6",
 /*                    "Teacher7","Teacher8","Teacher9",
                     "Teacher10","Teacher11","Teacher12",
                     "Teacher13","Teacher14"
*/
        };
        ArrayList<String> permutations = g.GeneratePermutations(elements);
       // ArrayList<String> acommodition = g.GenerateAccommodation(elements);

        int comb = elements.length * (elements.length-1)*(elements.length-2);

        System.out.println("Number of combinations = " + comb);

        for ( String s : permutations)
        {
            System.out.println(s);
        }
        /*
        for ( String s : acommodition)
        {
            System.out.println(s);
        }

       */
    }
}
