package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Graph {
    public int numberOfPeaks;
    public float density;
    ArrayList<LinkedList<ArcCost>> graphList = new ArrayList<LinkedList<ArcCost>>();

    public Graph(int numberOfPeaks, float density){
        int currentNumberOfArcs = 0;
        this.numberOfPeaks = numberOfPeaks;
        this.density = density;
        for (int index = 0; index < numberOfPeaks; index++){
            LinkedList<ArcCost> emptyLinkedList = new LinkedList<ArcCost>();
            graphList.add(index, emptyLinkedList);
        }
        while(currentNumberOfArcs < getExactNumberOfArcs()){
            boolean alreadyExists = false;
            Random random = new Random();
            int randomSourcePeak = random.nextInt(numberOfPeaks);
            int randomDestinationPeak = random.nextInt(numberOfPeaks);
            int randomCost = random.nextInt(100-1) + 1;
            if (randomSourcePeak != randomDestinationPeak){
                ArcCost object = new ArcCost(randomSourcePeak, randomDestinationPeak, randomCost);
                for (int j = 0; j < graphList.get(randomSourcePeak).size(); j++){
                    if ((graphList.get(randomSourcePeak).get(j).getSource() == object.getSource()) && (graphList.get(randomSourcePeak).get(j).getDestination() == object.getDestination())){
                        alreadyExists = true;
                    }
                }
                if (!alreadyExists){
                    graphList.get(randomSourcePeak).add(object);
                    currentNumberOfArcs++;
                }
            }
        }
    }

    public int getNumberOfPeaks(){
        return numberOfPeaks;
    }

    public float getDensity(){
        return density;
    }

    public int getMaxNumberOfArcs(){
        return numberOfPeaks * (numberOfPeaks-1);
    }

    public int getExactNumberOfArcs(){
        return (int) (getMaxNumberOfArcs()*density);
    }
}
