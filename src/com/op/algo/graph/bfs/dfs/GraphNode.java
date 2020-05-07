package com.op.algo.graph.bfs.dfs;

public class GraphNode {

    private int e;
    private int val;
    private GraphNode next;

    public GraphNode(int e, int val, GraphNode next) {
        this.e = e;
        this.val = val;
        this.next = next;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public GraphNode getNext() {
        return next;
    }

    public void setNext(GraphNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GraphNode && e == ((GraphNode) obj).getE())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return e;
    }

    @Override
    public String toString() {
        return "(" + e + ", " + val + ")";
    }
}
