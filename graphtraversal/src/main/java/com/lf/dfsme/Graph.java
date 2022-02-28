package com.lf.dfsme;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;
    private boolean[] visited;
    private LinkedList<Integer> q;
    public Graph(int n){
        this.V = n;
        this.adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
        this.visited = new boolean[n];
        this.q = new LinkedList<>();
    }

    public void addEdge(int v,int e){
        adj[v].offer(e);
    }

    public void DFS(int s){

        //push
        q.addFirst(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int current = q.removeFirst();
            System.out.println(current+" ");
            visited[current] = true;
            Iterator<Integer> i = adj[current].iterator();
            while(i.hasNext()){
                int adjNode = i.next();
                if(!visited[adjNode]){
                    q.addFirst(adjNode);
                }
            }
        }
    }
    public static void main(String[] args) {
        test2();
    }
    public static void test(){
        Graph g = new Graph(4);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        int s = 2;
        System.out.println("DFS "+"from "+ s);
        g.DFS(s);
    }
    public static void test2(){
        Graph g = new Graph(11);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(0,4);
        g.addEdge(0,5);
        g.addEdge(0,6);
        g.addEdge(0,7);
        g.addEdge(0,8);
        g.addEdge(6,9);
        g.addEdge(8,10);


        int s = 0;
        System.out.println("DFS "+"from "+ s);
        g.DFS(s);
    }


}
