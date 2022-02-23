package com.lf.astarme;

public class Node implements Comparable<Node>{
    private int x;
    private int y;
    private Node parent;
    private int G;
    private int H;
    private int F;

    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }

    public Node() {
    }

    public Node(int x, int y, Node parent, int G, int H) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.G = G;
        this.H = H;
        this.F = G+H;

    }

    @Override
    public int compareTo(Node o) {
        if(this.F>=o.F)
            return 1;
        else
            return -1;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Node){
            Node node = (Node) obj;
            if (node.x == this.x && node.y == this.y){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * 设置
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获取
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * 设置
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 获取
     * @return parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * 设置
     * @param parent
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * 获取
     * @return G
     */
    public int getG() {
        return G;
    }

    /**
     * 设置
     * @param G
     */
    public void setG(int G) {
        this.G = G;
    }

    /**
     * 获取
     * @return H
     */
    public int getH() {
        return H;
    }

    /**
     * 设置
     * @param H
     */
    public void setH(int H) {
        this.H = H;
        //this.F = G+H;
    }

    /**
     * 获取
     * @return F
     */
    public int getF() {
        return F;
    }

    /**
     * 设置
     * @param F
     */
    public void setF(int F) {
        this.F = F;
    }

    public String toString() {
        return "Node{x = " + x + ", y = " + y + ", parent = " + parent + ", G = " + G + ", H = " + H + ", F = " + F + "}";
    }
}
