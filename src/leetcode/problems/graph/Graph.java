package leetcode.problems.graph;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int v_size;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    Graph(int size) {
        v_size = size;
        adj = new LinkedList[size];
        for (int i = 0; i < size; ++i)
            adj[i] = new LinkedList();
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);

        System.out.println("-----------");

        g.DFS(2);

        System.out.println("-----------");

        g.DFS_Iterative(2);
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int v_index) {
        if (v_index < 0 || v_index >= v_size) {
            throw new IllegalArgumentException("index is illegal");
        }

        boolean[] visited = new boolean[v_size];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(v_index);
        visited[v_index] = true;

        while (!queue.isEmpty()) {
            final Integer integer = queue.poll();
            System.out.println("visiting --> " + integer);

            final LinkedList<Integer> adjacent = adj[integer];
            for (Integer next : adjacent) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    void DFS(int v_index) {
        if (v_index < 0 || v_index >= v_size) {
            throw new IllegalArgumentException("index is illegal");
        }

        boolean[] visited = new boolean[v_size];
        DFS_Helper(v_index, visited);
    }

    void DFS_Helper(int v_index, boolean[] visited) {
        System.out.println("visiting --> " + v_index);
        final LinkedList<Integer> adjacent = adj[v_index];
        visited[v_index] = true;
        for (Integer next : adjacent) {
            if (!visited[next]) {
                DFS_Helper(next, visited);
            }
        }
    }

    private void DFS_Iterative(int start) {
        boolean[] visited = new boolean[v_size];
        Stack<Integer> stack = new Stack<>();
        pushFrom(start, stack, visited);
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int index = findUnvisitedIndex(top, visited);
            if (index >= 0) {
                pushFrom(index, stack, visited);
            }
        }
    }

    private int findUnvisitedIndex(int top, boolean[] visited) {
        final LinkedList<Integer> adjacents = adj[top];
        for (int num : adjacents) {
            if (!visited[num]) {
                return num;
            }
        }
        return -1;
    }

    private void pushFrom(int index, Stack<Integer> stack, boolean[] visited) {
        while (index >= 0) {
            stack.push(index);
            visited[index] = true;
            System.out.println("Visiting : " + index);
            index = findUnvisitedIndex(index, visited);
        }
    }
}
