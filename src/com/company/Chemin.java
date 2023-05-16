package com.company;

import java.util.ArrayList;

public class Chemin {
    public int totalCost;
    public ArrayList path = new ArrayList();

    public Chemin(int totalCost, ArrayList path){
        this.totalCost = totalCost;
        this.path = path;
    }

    public int getTotalCost(){
        return totalCost;
    }

    public ArrayList getPath(){
        return path;
    }

    public String toStringPath(ArrayList path){
        String res = "";
        for (int i =0; i < path.size(); i++){
            res = res + path.get(i) + " ";
        }
        return res;
    }
}
