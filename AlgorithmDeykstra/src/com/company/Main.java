package com.company;

public class Main {

    public static void main(String[] args) {
         int size = 6;
         AlgDeykstra deykstra = new AlgDeykstra(size);
         //deykstra.initializeMatrix();
         deykstra.initializePoints();
         deykstra.CalculatePoint();
         deykstra.findClosestPath();
         deykstra.printBestDistances();
         deykstra.printBestPath();
    }
}
