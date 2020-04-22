package com.code.algo.graph.bfs.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BFS {

    public void doBFS(Graph g, int start) {
        Set<GraphNode> set = g.graph.keySet();
        boolean visited[] = new boolean[set.size()];
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        GraphNode temp = new GraphNode(start, 0, null);
        queue.add(temp);
        while (queue.size() != 0) {
            if (!visited[queue.get(0).getE()]) {
                visited[queue.get(0).getE()] = true;
                System.out.print(queue.get(0).getE() + " -> ");
                List<GraphNode> li = g.graph.get(queue.get(0));
                queue.remove(queue.get(0));
                queue.addAll(li);
            }
        }
        System.out.println();
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

        new BFS().doBFS(g, 2);
    }

}
