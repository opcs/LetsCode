package com.code.algo.graph.bfs.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearch {
    // recursive dfs
    private static void dfs_rec(ArrayList<ArrayList<Integer>> adjLists, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int w : adjLists.get(v)) {
            if (!visited[w]) {
                dfs_rec(adjLists, visited, w);
            }
        }
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adjLists, int s) {
        int n = adjLists.size();
        boolean[] visited = new boolean[n];
        dfs_rec(adjLists, visited, s);
    }
    public static void dfs_iterative(ArrayList<ArrayList<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> st = new Stack<Integer>();
        st.push(s);
        while (!st.isEmpty()) {
            int v = st.pop();
            if (!visited[v]) {
                visited[v] = true;
                System.out.print(v + " ");
                Stack<Integer> auxStack = new Stack<Integer>();
                for (int w : adj.get(v)) {
                    if (!visited[w]) {
                        auxStack.push(w);
                    }
                }
                while (!auxStack.isEmpty()) {
                    st.push(auxStack.pop());
                }
            }
        }
    }

    public static void bfs_iterative(ArrayList<ArrayList<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        System.out.println("start bfs iterative");
        while (!queue.isEmpty()) {
            int v = queue.remove();
            if (!visited[v]) {
                visited[v] = true;
                System.out.print(v + " ");
                for (int w : adj.get(v)) {
                    if (!visited[w]) {
                        queue.add(w);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        // Create adjacency list representation
        ArrayList<ArrayList<Integer>> adjLists = new ArrayList<ArrayList<Integer>>();
        final int n = 7;
        // Add an empty adjacency list for each vertex
        for (int v = 0; v < n; v++) {
            adjLists.add(new ArrayList<Integer>());
        }
        // insert neighbors of vertex 0 into adjacency list for vertex 0
        adjLists.get(0).add(1);
        adjLists.get(0).add(2);
        adjLists.get(0).add(3);

        adjLists.get(1).add(5);
        adjLists.get(1).add(6);
        adjLists.get(2).add(4);
        adjLists.get(3).add(2);
        adjLists.get(3).add(4);
        adjLists.get(4).add(1);
        adjLists.get(6).add(4);
        // dfs(adjLists, 0);
        dfs_iterative(adjLists, 0);
        bfs_iterative(adjLists, 0);
    }
}
