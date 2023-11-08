package com.company;
import java.util.ArrayList;
import java.util.Arrays;

public class DefCombinatorial
{

    public ArrayList<String> GeneratePermutations(String[] felements)
    {
        ArrayList<String> permutations = new ArrayList<String>();

        if(felements.length == 2)
        {
            String x1 = felements[0]  + felements[1];
            String x2 = felements[1]  + felements[0];
            permutations.add(x1);
            permutations.add(x2);
        }
        else
        {
            for (int i = 0; i < felements.length; i++)
            {
                String[] selements = new String[felements.length - 1];

                int ind = 0;

                for (int j = 0; j < selements.length; j++)
                {
                    if (i == j)
                    {
                        ind = 1;
                    }
                    selements[j] = felements[j+ind];
                }
                ArrayList<String> perm = GeneratePermutations(selements);

                for (String x : perm)
                {
                    String s = felements[i] + x;
                    permutations.add(s);
                }
            }
        }
        return permutations;
    }

    public ArrayList<String> GenerateAccommodation(String[] felements)
    {
        ArrayList<String> accomodition = new ArrayList<String>();

        if(felements.length == 3)
        {
            String x1 = felements[0]  + felements[1] + felements[2];
            String x2 = felements[0]  + felements[2] + felements[1];
            String x3 = felements[1]  + felements[0] + felements[2];
            String x4 = felements[1]  + felements[2] + felements[0];
            String x5 = felements[2]  + felements[0] + felements[1];
            String x6 = felements[2]  + felements[1] + felements[0];
            accomodition.add(x1);
            accomodition.add(x2);
            accomodition.add(x3);
            accomodition.add(x4);
            accomodition.add(x5);
            accomodition.add(x6);

        }
        else
        {
            for (int i = 0; i < felements.length; i++)
            {
                String[] selements = new String[felements.length - 1];

                int ind = 0;

                for (int j = 0; j < selements.length; j++)
                {
                    if (i == j)
                    {
                        ind = 1;
                    }
                    selements[j] = felements[j + ind];
                }

                ArrayList<String> acom = GenerateAccommodation(selements);

                for (String x : acom)
                {
                    accomodition.add(x);
                }
                Arrays.sort(accomodition.toArray());
            }
        }
        return accomodition;
    }

}
