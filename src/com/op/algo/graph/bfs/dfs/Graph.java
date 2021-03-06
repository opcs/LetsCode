package com.op.algo.graph.bfs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Graph {

    HashMap<GraphNode, List<GraphNode>> graph = new HashMap<GraphNode, List<GraphNode>>();

    public void addEdgeDirected(int e, int val, GraphNode next) {
        GraphNode newNode = new GraphNode(e, val, next);
        next.setNext(newNode);
        Set<GraphNode> set = graph.keySet();
        if (set.contains(newNode))
            if (graph.get(newNode) == null) {
                List<GraphNode> li = new ArrayList<GraphNode>();
                li.add(next);
                graph.put(newNode, li);
            }
            else {
                List<GraphNode> temp = graph.get(newNode);
                temp.add(next);
                graph.put(newNode, temp);
            }
        else {
            List<GraphNode> li = new ArrayList<GraphNode>();
            li.add(next);
            graph.put(newNode, li);
        }
    }

    public void addEdge(int e, int val, GraphNode next) {
        GraphNode newNode = new GraphNode(e, val, next);
        next.setNext(newNode);
        Set<GraphNode> set = graph.keySet();
        if (set.contains(newNode))
            if (graph.get(newNode) == null) {
                List<GraphNode> li = new ArrayList<GraphNode>();
                li.add(next);
                graph.put(newNode, li);
            }
            else {
                List<GraphNode> temp = graph.get(newNode);
                temp.add(next);
                graph.put(newNode, temp);
            }
        else {
            List<GraphNode> li = new ArrayList<GraphNode>();
            li.add(next);
            graph.put(newNode, li);
        }
        if (set.contains(next))
            if (graph.get(next) == null) {
                List<GraphNode> li = new ArrayList<GraphNode>();
                li.add(newNode);
                graph.put(next, li);
            }
            else {
                List<GraphNode> temp = graph.get(next);
                temp.add(newNode);
                graph.put(next, temp);
            }
        else {
            List<GraphNode> li = new ArrayList<GraphNode>();
            li.add(newNode);
            graph.put(next, li);
        }
    }

    public static void main(String[] args) {
        GraphNode zero = new GraphNode(0, 0, null);
        GraphNode one = new GraphNode(1, 0, null);
        GraphNode two = new GraphNode(2, 0, null);
        GraphNode three = new GraphNode(3, 0, null);
        GraphNode four = new GraphNode(4, 0, null);
        Graph g = new Graph();
        g.addEdge(0, 0, one);
        g.addEdge(0, 0, four);
        g.addEdge(1, 0, two);
        g.addEdge(1, 0, three);
        g.addEdge(1, 0, four);
        g.addEdge(2, 0, three);
        g.addEdge(3, 0, four);
        System.out.println(g.graph);
    }

}
