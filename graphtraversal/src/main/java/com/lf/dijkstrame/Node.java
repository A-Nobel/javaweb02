package com.lf.dijkstrame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Node {
    public int v;
    public ArrayList<Integer> adj;
    public ArrayList<Integer> cost;

    public Node(int v){
        this.v = v;
        adj = new ArrayList<>();
        cost = new ArrayList<>();
    }
    public void addEdge(int e,int c){
        adj.add(e);
        cost.add(c);
    }

//    @Override
//    public int compareTo(Node o) {
//        if(cost>o.cost)
//            return 1;
//
//        return 0;
//    }
}
