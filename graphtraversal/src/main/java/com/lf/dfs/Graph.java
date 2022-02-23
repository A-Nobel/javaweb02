package com.lf.dfs;

//BFS

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;
    private boolean[] visited;
    //Constructor of a graph
    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList();
        }
    }

    //Add edge
    void addEdge(int v, int w){
        adj[v].add(w);
    }

    //BFS
    void DFS(int s) {
        visited[s] = true;
        System.out.println(s + " ");

        Iterator<Integer> i = adj[s].listIterator();
        while(i.hasNext()){
            int n = i.next();
            System.out.println("ire"+n);
            if(!visited[n]){
                DFS(n);
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
        g.DFS(s);
    }
}
