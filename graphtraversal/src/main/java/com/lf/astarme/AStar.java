package com.lf.astarme;

import java.util.*;


public class AStar {
    Queue<Node> queue = new PriorityQueue<>();
    List<Node> list = new ArrayList<>();

    int[][] map;
    int[][] map2;
    public void start(MapInfo mapInfo){
        map = new int[mapInfo.maps.length][mapInfo.maps[0].length];
        map2 = new int[mapInfo.maps.length][mapInfo.maps[0].length];
        for(int i = 0;i<mapInfo.maps.length;i++)
        {
            for(int j= 0 ;j<mapInfo.maps[i].length;j++)
            {
                map[i][j] = mapInfo.maps[i][j];
            }
        }
        for(int i = 0;i<mapInfo.maps.length;i++)
        {
            for(int j= 0 ;j<mapInfo.maps[i].length;j++)
            {
                map2[i][j] = mapInfo.maps[i][j];
            }
        }

        map[mapInfo.start.getX()][mapInfo.start.getY()] = 9;
        map[mapInfo.end.getX()][mapInfo.end.getY()] = 9;
        queue.clear();
        list.clear();
        mapInfo.start.setG(0);
        mapInfo.start.setParent(new Node(-1,-1));
        queue.offer(mapInfo.start);
        while(true){
            Node current = queue.poll();
            map[current.getX()][current.getY()] = 9;
            System.out.println("coord ("+current.getX()+" "+current.getY()+") "+current.getG()+" "+current.getH()+" "+current.getF()+" parent("+current.getParent().getX()+" "+current.getParent().getX()+")");
            list.add(current);

            if(current.equals(mapInfo.end))
            {
                while(current.getParent()!=null){
                    map2[current.getX()][current.getY()] = 8;
                    //System.out.print("g ");
                    //System.out.println(current.getX()+" "+current.getY());
                    current = current.getParent();

                }
                break;
            }
            dealWithNeighbour(current,mapInfo.maps,mapInfo.end);

        }


        String ANSI_BLACK = "\u001B[30m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_WHITE = "\u001B[37m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        for (int i = 0; i < map.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < map[i].length; j++) { //this equals to the column in each row.
                if(map[i][j] == 9)
                    System.out.print(ANSI_RED+map[i][j] + " "+ANSI_RESET);
                else
                    System.out.print(map[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }

        System.out.println();

        for (int i = 0; i < map2.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < map2[i].length; j++) { //this equals to the column in each row.
                if(map2[i][j] == 8)
                    System.out.print(ANSI_GREEN+map2[i][j] + " "+ANSI_RESET);
                else
                    System.out.print(map2[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }

        System.out.println();


    }

    public void dealWithNeighbour(Node node,int[][] m,Node end){
        for(int i = -1; i <= 1;i++){
            for (int j = -1; j <= 1; j++) {
                if(i==0 && j == 0) continue;
                int X = node.getX()+i;
                int Y = node.getY()+j;
                if(X< 0|| Y<0 || X>= m.length || Y >= m[0].length) continue;
                if(m[X][Y] == 1) continue;
                boolean flag = false;
                for (int k = 0; k < list.size(); k++) {
                    Node node1 = list.get(k);
                    if(X == node1.getX() && Y == node1.getY()){
                        flag = true;
                    }
                }
                if(flag) continue;
                Node nei = newG(node,new Node(X,Y),m,end);

                boolean flagInOpen = false;
                for(Node nnn : queue){
                    if(nei.equals(nnn))
                        flagInOpen = true;
                }
                if(!flagInOpen)
                queue.offer(nei);

            }
        }
    }

    public Node newG(Node p, Node node,int[][] m,Node end){
        Node min = p;
        for(int i = -1; i <= 1;i++){
            for (int j = -1; j <= 1; j++) {
                if (i ==0 && j == 0) continue;
                int X = node.getX()+i;
                int Y = node.getY()+j;
                if(X< 0|| Y<0 ||X>= m.length || Y >= m[0].length) continue;
                if(m[X][Y] == 1) continue;

                for (int k = 0; k < list.size(); k++) {
                    Node node1 = list.get(k);
                    if(X == node1.getX() && Y == node1.getY()){
                        if(node1.getG()< min.getG())
                        min = node1;
                    }
                }
            }
        }

        Node parent = (min);
        node.setParent(min);
        int i = parent.getX() - node.getX();
        int j = parent.getY() - node.getY();
        int X = node.getX();
        int Y = node.getY();
        int G = ((Math.abs(i)+Math.abs(j)==2)?node.getParent().getG()+14:node.getParent().getG()+10);
        int eX = end.getX();
        int eY = end.getY();

        int x = Math.abs(eX - X);
        int y = Math.abs(eY - Y);
        //2 4

        int H = x > y ? (x-Math.abs(x - y))*10+Math.abs(x - y)*14 : (y-Math.abs(x - y))*10+Math.abs(x - y)*14;
        //System.out.println(x+" "+y+" "+(G+H));
        //node.setParent(min);
        node.setG(G);
        node.setH(H);
        node.setF(G+H);
        return node;

    }
}

