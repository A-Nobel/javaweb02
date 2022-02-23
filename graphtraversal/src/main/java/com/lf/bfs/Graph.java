package com.lf.bfs;

//BFS

import java.util.*;
public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    //Constructor of a graph
    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList();
        }
    }

    //Add edge
    void addEdge(int v, int w){
        adj[v].add(w);
    }

    //BFS
    void BFS(int s) {
        boolean[] visited = new boolean[V];

        LinkedList<Integer> queue = new LinkedList();
        visited[s] = true;
        queue.add(s);
        while(queue.size() != 0){
            s = queue.poll();
            System.out.println(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                System.out.println("ire"+n);
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        int s = 2;
        System.out.println("BFS "+"from "+ s);
        g.BFS(s);
    }
}
