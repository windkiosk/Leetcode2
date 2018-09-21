package leetcode.problems.graph.mothervetex;

import java.util.LinkedList;

public class Graph {
    int V;    // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    Graph(int size) {
        V = size;
        adj = new LinkedList[size];
        for (int i = 0; i < size; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
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

    int findMother() {
        // visited[] is used for DFS. Initially all are
        // initialized as not visited
        boolean[] visited = new boolean[V];

        // To store last finished vertex (or mother vertex)
        int v = 0;

        // Do a DFS traversal and find the last finished
        // vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS_Helper(i, visited);
                v = i;
            }
        }

        // If there exist mother vertex (or vetices) in given
        // graph, then v must be one (or one of them)

        // Now check if v is actually a mother vertex (or graph
        // has a mother vertex).  We basically check if every vertex
        // is reachable from v or not.

        // Reset all values in visited[] as false and do
        // DFS beginning from v to check if all vertices are
        // reachable from it or not.
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        DFS_Helper(v, visited);
        for (int i = 0; i < V; i++)
            if (!visited[i])
                return -1;

        return v;
    }

    // Driver program to test above functions
    public static void main(String[] strings) {
        // Create a graph given in the above diagram
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);

        System.out.println("A mother vertex is " + g.findMother());
    }
}
