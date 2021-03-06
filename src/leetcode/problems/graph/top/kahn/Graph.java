package leetcode.problems.graph.top.kahn;

// A Java program to print topological sorting of a graph
// using indegrees

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

//Class to represent a graph
class Graph {
    int v_size;// No. of vertices

    //An Array of List which contains
    //references to the Adjacency List of
    //each vertex
    List<Integer> adj[];

    public Graph(int v_size)// Constructor
    {
        this.v_size = v_size;
        adj = new ArrayList[v_size];
        for (int i = 0; i < v_size; i++)
            adj[i] = new ArrayList<>();
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is a Topological Sort");
        g.topologicalSort();

    }

    // function to add an edge to graph
    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // prints a Topological Sort of the complete graph
    public void topologicalSort() {
        // Create a array to store indegrees of all
        // vertices. Initialize all indegrees as 0.
        int indegree[] = new int[v_size];

        // Traverse adjacency lists to fill indegrees of
        // vertices. This step takes O(v_size+E) time
        for (int i = 0; i < v_size; i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
            for (int node : temp) {
                indegree[node]++;
            }
        }

        // Create a queue and enqueue all vertices with
        // indegree 0
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < v_size; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        // Initialize count of visited vertices
        int cnt = 0;

        // Create a vector to store result (A topological
        // ordering of the vertices)
        Vector<Integer> topOrder = new Vector<Integer>();
        while (!q.isEmpty()) {
            // Extract front of queue (or perform dequeue)
            // and add it to topological order
            int u = q.poll();
            topOrder.add(u);

            // Iterate through all its neighbouring nodes
            // of dequeued node u and decrease their in-degree
            // by 1
            for (int node : adj[u]) {
                // If in-degree becomes zero, add it to queue
                if (--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }

        // Check if there was a cycle
        if (cnt != v_size) {
            System.out.println("There exists a cycle in the graph");
            return;
        }

        // Print topological order
        for (int i : topOrder) {
            System.out.print(i + " ");
        }
    }
}
