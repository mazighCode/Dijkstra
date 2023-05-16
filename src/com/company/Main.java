package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
                                // Pour génerer un graphe aléatoire
        //long start = System.currentTimeMillis();
        Graph graph = new Graph(4, 0.5F);
        //long end = System.currentTimeMillis();
        //double time = (end-start)/1000.0;
        //System.out.println(time+" s");



        /*
                                // Pour construire un graphe à la main
        Graph graph = new Graph(6, 0);
        LinkedList<ArcCost> list = new LinkedList<ArcCost>();


        graph.graphList.get(0).add(new ArcCost(0, 1, 14));
        graph.graphList.get(0).add(new ArcCost(0, 2, 1));
        graph.graphList.get(0).add(new ArcCost(0, 5, 99));
        graph.graphList.get(1).add(new ArcCost(1, 3, 1));
        graph.graphList.get(1).add(new ArcCost(1, 4, 17));
        graph.graphList.get(2).add(new ArcCost(2, 0, 5));
        graph.graphList.get(2).add(new ArcCost(2, 1, 12));
        graph.graphList.get(2).add(new ArcCost(2, 3, 14));
        graph.graphList.get(2).add(new ArcCost(2, 4, 29));
        graph.graphList.get(2).add(new ArcCost(2, 5, 90));
        graph.graphList.get(3).add(new ArcCost(3, 1, 10));
        graph.graphList.get(3).add(new ArcCost(3, 4, 40));
        graph.graphList.get(3).add(new ArcCost(3, 5, 50));
        graph.graphList.get(4).add(new ArcCost(4, 5, 20));
        graph.graphList.get(5).add(new ArcCost(5, 3, 10));
         */


        for (int i = 0; i < graph.getNumberOfPeaks(); i++){
            for (int j = 0; j < graph.graphList.get(i).size(); j++){
                System.out.println(graph.graphList.get(i).get(j).getSource() + " " + graph.graphList.get(i).get(j).getDestination() + " " + graph.graphList.get(i).get(j).getCost());
            }
        }


        System.out.println(" ---------------------");
        Dijkstra test = new Dijkstra();
        if(test.dijkstra(graph, 0, graph.getNumberOfPeaks()-1).getTotalCost() == 2147483647){
            System.out.println("Il n'y a pas de chemin qui mène de la source à la destination");
        } else {
            System.out.println("Le meilleur cout entre la source et la destination est: " + test.dijkstra(graph, 0, graph.getNumberOfPeaks()-1).getTotalCost());
            System.out.println("Le chemin: " + test.dijkstra(graph, 0, graph.getNumberOfPeaks()-1).getPath());
        }


    }
}


