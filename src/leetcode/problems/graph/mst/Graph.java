package leetcode.problems.graph.mst;

// Java program for Kruskal's algorithm to find Minimum Spanning Tree
// of a given connected, undirected and weighted graph

import java.util.Arrays;

class Graph {
    int v_size, edge_size;    // v_size-> no. of vertices & edge_size->no.of edges

    Edge edge[]; // collection of all edges

    // Creates a graph with v_size vertices and edge_size edges
    Graph(int v_size, int edge_size) {
        this.v_size = v_size;
        this.edge_size = edge_size;
        edge = new Edge[this.edge_size];
        for (int i = 0; i < edge_size; ++i)
            edge[i] = new Edge();
    }

    // Driver Program
    public static void main(String[] args) {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }

    // A utility function to find set of an element i
    // (uses path compression technique)
    int find(Subset subsets[], int i) {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y
    // (uses union by rank)
    void union(Subset subsets[], int x, int y) {
        int x_root = find(subsets, x);
        int y_root = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree
        // (union by Rank)
        if (subsets[x_root].rank < subsets[y_root].rank)
            subsets[x_root].parent = y_root;
        else if (subsets[x_root].rank > subsets[y_root].rank)
            subsets[y_root].parent = x_root;

            // If ranks are same, then make one as root and increment
            // its rank by one
        else {
            subsets[y_root].parent = x_root;
            subsets[x_root].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    void KruskalMST() {
        Edge result[] = new Edge[v_size];  // This will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i = 0; i < v_size; ++i)
            result[i] = new Edge();

        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edge);

        // Allocate memory for creating v_size subsets
        Subset subsets[] = new Subset[v_size];
        for (i = 0; i < v_size; ++i)
            subsets[i] = new Subset();

        // Create v_size subsets with single elements
        for (int v = 0; v < v_size; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;  // Index used to pick next edge

        // Number of edges to be taken is equal to v_size-1
        while (e < v_size - 1) {
            // Step 2: Pick the smallest edge. And increment the index
            // for next iteration
            Edge next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle, include it
            // in result and increment the index of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display the built MST
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(
                    result[i].src
                            + " -- "
                            + result[i].dest
                            + " == "
                            + result[i].weight);
    }

    // A class to represent a graph edge
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // Comparator function used for sorting edges based on
        // their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // A class to represent a Subset for union-find
    class Subset {
        int parent, rank;
    }
}
