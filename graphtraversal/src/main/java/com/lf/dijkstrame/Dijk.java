package com.lf.dijkstrame;

public class Dijk {
    public static void main(String[] args) {

    }
    public static void test(){
        int total = 11;
        Graph g = new Graph(total);
        for (int i = 0; i < total; i++) {
            g.nodes[i] = new Node(i);
        }
        g.nodes[0].addEdge(1,10);
        g.nodes[0].addEdge(2,1);
        g.nodes[0].addEdge(3,2);
        g.nodes[0].addEdge(4,3);
        g.nodes[0].addEdge(5,4);
        g.nodes[0].addEdge(6,5);
        g.nodes[0].addEdge(7,7);
        g.nodes[0].addEdge(8,1);
        g.nodes[8].addEdge(10,1);
        g.nodes[6].addEdge(10,0);

    }
}


