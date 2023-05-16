package com.company;

public class ArcCost {
    public int source;
    public int destination;
    public int cost;

    public ArcCost(int source, int destination, int cost){
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public int getSource(){
        return source;
    }

    public int getDestination(){
        return destination;
    }

    public int getCost(){
        return cost;
    }
}
