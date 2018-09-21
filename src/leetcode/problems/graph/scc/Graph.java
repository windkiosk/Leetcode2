package leetcode.problems.graph.scc;

// Java implementation of Kosaraju's algorithm to print all SCCs

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

// This class represents a directed graph using adjacency list
// representation
class Graph {
    private int v_size;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    //Constructor
    Graph(int v) {
        v_size = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Driver method
    public static void main(String args[]) {

        /*

        1 ---> 0 ---> 3 ----> 4
        ^      |
        |      |
        |      |
        2 <--<-|

         */

        // Create a graph given in the above diagram
        Graph graph = new Graph(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        graph.printSCCs();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // A recursive function to print DFS starting from v
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        int n;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // Function that returns reverse (or transpose) of this graph
    Graph reverse() {
        Graph reversed = new Graph(v_size);
        for (int v = 0; v < v_size; v++) {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
                reversed.adj[i.next()].add(v);
        }
        return reversed;
    }

    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                fillOrder(n, visited, stack);
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack
        stack.push(v);
    }

    // The main function that finds and prints all strongly
    // connected components
    void printSCCs() {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[v_size];
        for (int i = 0; i < v_size; i++)
            visited[i] = false;

        // Fill vertices in stack according to their finishing
        // times
        for (int i = 0; i < v_size; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        // Create a reversed graph
        Graph reversed_graph = reverse();

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < v_size; i++)
            visited[i] = false;

        // Now process all vertices in order defined by Stack
        while (!stack.empty()) {
            // Pop a vertex from stack
            int v = stack.pop();

            // Print Strongly connected component of the popped vertex
            if (!visited[v]) {
                reversed_graph.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }
}
