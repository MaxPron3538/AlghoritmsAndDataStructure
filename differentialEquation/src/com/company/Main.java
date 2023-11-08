package com.company;
import java.util.Scanner;
import java.util.function.Function;

public class Main
{
    public static double Func(double x,double y)
    {
        return Math.pow(Math.E,2*x) - y;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        double init = 0, end, step;

        System.out.println("Enter the value of the end of the interval");

        end = in.nextDouble();

        System.out.println("Enter the interval step");

        step = in.nextDouble();

        double section = (end - init) / step;

        double[] X = new double[((int) section)];
        double[] K1 = new double[((int) section)];
        double[] K2 = new double[((int) section)];
        double[] K3 = new double[((int) section)];
        double[] Y = new double[((int) section)];

        X[0] = init;

        System.out.println("Enter the initial value of Y");

        Y[0] = in.nextDouble();

        for (int i = 1; i <= section; i++)
        {
            X[i] = init + i * step;
            K1[i] = step * Func(X[i - 1], Y[i - 1]);
            K2[i] = step * Func(X[i - 1] + step / 2.0, Y[i - 1] + K1[i] / 2.0);
            K3[i] = step * Func(X[i - 1] + step, Y[i - 1] + 2 * K2[i] - K1[i]);
            Y[i] = Y[i - 1] + (K1[i] + 4 * K2[i] + 2 * K3[i]) / 6;
        }

        for (int i = 0; i <= section; i++)
        {
            System.out.print(X[i] + "\t");
        }

        System.out.println("\n");

        for (int i = 0; i <= section; i++)
        {
            System.out.print(Y[i] + "\t");
        }
    }
}
