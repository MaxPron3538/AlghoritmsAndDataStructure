package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AlgDeykstra {
    private int size;
    private int[][] matrixWeight = {
        {0,7,5,0,0,8},
        {7,0,0,10,0,0},
        {5,0,0,9,0,13},
        {0,10,9,0,12,0},
        {0,0,0,12,0,22},
        {8,0,13,0,22,0}
    };
    private Scanner scanner;
    private List<Integer> bestDistances;
    private List<Integer> visitedNodes;

    AlgDeykstra(int size){
       this.size = size;
       scanner = new Scanner(System.in);
       bestDistances = new ArrayList<>(size);
       visitedNodes = new ArrayList<>(size);
    }

    public void initializeMatrix(){
        for(int i = 0;i < size;i++){
            matrixWeight[i][i] = 0;

            for (int j = i+1;j < size;j++){
               System.out.println("Input weight of matrix:");
               int weight = scanner.nextInt();
               matrixWeight[i][j] = weight;
               matrixWeight[j][i] = weight;
            }
            System.out.println("\n");
        }
    }

    public void initializePoints(){
        for(int i = 0;i < size;i++){
            bestDistances.add(10000);
        }
        bestDistances.set(0,0);
    }

    public void CalculatePoint(){
        int current;
        int index = 0;

        while(index < size){
            current = bestDistances.get(index);
            for (int i = 0;i<size;i++) {
                if (matrixWeight[index][i] != 0) {
                    int newPoint = current + matrixWeight[index][i];
                    if(newPoint < bestDistances.get(i)) {
                        bestDistances.set(i, newPoint);
                    }
                }
            }
            index++;
        }
    }

    public void findClosestPath(){
        int endNode = 4;
        int currentNode = endNode;
        int distance = bestDistances.get(endNode);
        visitedNodes.add(endNode+1);

        while (distance != 0){
            for (int i = 0;i < size;i++){
                if(matrixWeight[currentNode][i] != 0){
                    int weight = distance - matrixWeight[currentNode][i];

                    if(weight == bestDistances.get(i)){
                        currentNode = i;
                        distance = weight;
                        visitedNodes.add(0,i+1);
                    }
                }
            }
        }
    }

    public void printBestDistances(){
        for (int i : bestDistances){
            System.out.print(i+ " , ");
        }
        System.out.println();
    }

    public void printBestPath(){
        for (int i : visitedNodes){
            System.out.print(i+ " , ");
        }
    }
}
