package com.lf.dijkstrame;

import java.util.*;
public class Graph {
    public Node[] nodes;

    public boolean[] visited;
    public LinkedList<Integer> list;

    public Graph(int n) {
        nodes = new Node[n];
        list = new LinkedList<>();
        visited = new boolean[n];
    }
    public void dijk(int s){

        list.add(s);
        while(!list.isEmpty()){
            int current = list.poll();
            visited[current] = true;
            for (int i = 0; i < nodes[current].adj.size(); i++) {

            }
        }

    }

}
