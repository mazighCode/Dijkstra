package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {

    public Chemin dijkstra(Graph graph, int source, int destination){
        int [] dijkstraTable = new int[graph.getNumberOfPeaks()];
        int [] path = new int[graph.getNumberOfPeaks()];
        boolean[] marks = new boolean[graph.getNumberOfPeaks()];
        for (int i = 0; i < graph.getNumberOfPeaks(); i++){
                if (i == source){
                    dijkstraTable[i] = 0;
                }
                else {
                    dijkstraTable[i] = 2147483647;
                }
        }

        for (int i=0; i < path.length; i++){
            path[i] = i;
        }

        for (int j=0; j < marks.length; j++){
            marks[j] = false;
        }
        int counter = 0;
        while (counter <= dijkstraTable.length+1){

            int peakOfMinimumCost = extractMin(dijkstraTable, marks);
            marks[peakOfMinimumCost] = true;
            counter ++;
            for (int i=0; i < graph.graphList.get(peakOfMinimumCost).size(); i++){

                if (dijkstraTable[peakOfMinimumCost] + graph.graphList.get(peakOfMinimumCost).get(i).getCost() < dijkstraTable[graph.graphList.get(peakOfMinimumCost).get(i).getDestination()]){
                    dijkstraTable[graph.graphList.get(peakOfMinimumCost).get(i).getDestination()] = dijkstraTable[peakOfMinimumCost] + graph.graphList.get(peakOfMinimumCost).get(i).getCost();
                    path[graph.graphList.get(peakOfMinimumCost).get(i).getDestination()] = peakOfMinimumCost;
                }
            }

        }

        ArrayList chemin = getPath(path);
        Chemin costAndPath = new Chemin(dijkstraTable[destination], chemin);
        return costAndPath;
    }



    public static int extractMin(int[] intArray, boolean[] boolArray){
        int minIndex = 0;
        int minimum = 2147483647;
        for(int i=1;i<intArray.length;i++){
            if(intArray[i] < minimum && boolArray[i] == false){
                minIndex = i;
                minimum = intArray[i];
            }
        }
        return minIndex;
    }

    static ArrayList getPath(int [] table){
        ArrayList resTable = new ArrayList();
        int j = 0;
        int i = table.length-1;
        while(table[i] != i){
            resTable.add(j, i);
            i = table[i];
            j++;
        }
        resTable.add(j, 0);
        Collections.reverse(resTable);
        return resTable;
    }
}
