package com.op.algo.graph.bfs.dfs;

import java.util.List;

public class DFS {

    public void doDFS(Graph g, int start, boolean visited[]) {
        if (!visited[start]) {
            visited[start] = true;
            System.out.print(start + " -> ");
            List<GraphNode> li = g.graph.get(new GraphNode(start, 0, null));
            for (GraphNode n : li)
                doDFS(g, n.getE(), visited);
        }
    }

    public static void main(String[] args) {
        GraphNode zero = new GraphNode(0, 0, null);
        GraphNode one = new GraphNode(1, 0, null);
        GraphNode two = new GraphNode(2, 0, null);
        GraphNode three = new GraphNode(3, 0, null);
        Graph g = new Graph();
        g.addEdgeDirected(0, 0, one);
        g.addEdgeDirected(0, 0, two);
        g.addEdgeDirected(1, 0, two);
        g.addEdgeDirected(2, 0, zero);
        g.addEdgeDirected(2, 0, three);
        g.addEdgeDirected(3, 0, three);
        System.out.println(g.graph);

        boolean visited[] = new boolean[g.graph.keySet().size()];
        new DFS().doDFS(g, 2, visited);
    }


}

