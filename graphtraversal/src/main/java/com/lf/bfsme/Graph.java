package com.lf.bfsme;

import java.util.*;
public class Graph {
    public  LinkedList<Integer>[] adj;

    public boolean[] visited;
    public Queue<Integer> queue;
    public Graph(int n){
        adj = new LinkedList[n];
        visited = new boolean[n];
        queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v,int e){
        adj[v].add(e);
    }

    public void BFS(int s){
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()){

            int current = queue.poll();
            System.out.println(current);
            Iterator<Integer> i = adj[current].listIterator();
            while(i.hasNext()){
                int adjNode = i.next();
                //System.out.println("now "+adjNode);
                if(!visited[adjNode]){
                    visited[adjNode] = true;
                    queue.offer(adjNode);
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
        System.out.println("BFS "+"from "+ s);
        g.BFS(s);
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
        System.out.println("BFS "+"from "+ s);
        g.BFS(s);
    }

}
