package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int count = 2,firstcount = 1,afcount = 0;

        byte[][] Array_first = new byte[6][6];
        byte[][] Array_second = new byte[6][6];

          for(int i = 0;i < 6;i++)
          {
            for(int j = 0;j < 6;j++)
            {
                Array_first[i][j] = (byte)(Math.random() * 127f);
            }
          }

          for(int i = Array_first.length - 1;i >= 0;i--)
          {
            for(int j = 0;j < Array_first.length;j++)
            {
                if(i + count >= Array_first.length)
                {
                    Array_second[i][j] = Array_first[i + count - Array_first.length][j];
                    Array_second[i - count][j] = Array_first[i][j];
                }
                else
                {
                    if(i >= count)  Array_second[i - count][j] = Array_first[i][j];
                }
            }
          }

          System.out.println("Input data:");

          for(int i = 0;i < Array_first.length;i++)
          {
             for(int j = 0;j < Array_first.length;j++)
             {
                System.out.print(Array_first[i][j]);
                 System.out.print(" ");
             }
             System.out.println("\n");
          }

          System.out.println("Output data:" + "\n");

          for(int i = 0;i < Array_second.length;i++)
          {
              for(int j = 0;j < Array_second.length;j++)
              {
                  System.out.print(Array_second[i][j]);
                  System.out.print(" ");
              }
              System.out.println("\n");
          }

    }

}
