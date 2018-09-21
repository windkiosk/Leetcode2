package leetcode.problems.graph.cycle;

import java.util.LinkedList;

public class DetectCycleInDirected {

    static class Graph {
        private int v_size;   // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency List

        //Constructor
        Graph(int v_size) {
            this.v_size = v_size;
            adj = new LinkedList[v_size];
            for (int i = 0; i < v_size; ++i)
                adj[i] = new LinkedList<>();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        private boolean isCyclicUtil(int index, boolean[] visited, boolean[] recur) {
            visited[index] = true;
            recur[index] = true;

            final LinkedList<Integer> adjacents = adj[index];
            for (int i : adjacents) {
                if (!visited[i] && isCyclicUtil(i, visited, recur)) {
                    return true;
                } else if (recur[i]) {
                    return true;
                }
            }
            recur[index] = false;
            return false;
        }

        public boolean isCyclic() {
            boolean[] visited = new boolean[v_size];
            boolean[] recur = new boolean[v_size];

            for (int i = 0; i < v_size; i++) {
                if (isCyclicUtil(i, visited, recur)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        if (g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");

        g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        if (g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
