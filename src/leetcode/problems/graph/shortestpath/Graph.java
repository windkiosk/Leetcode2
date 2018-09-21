package leetcode.problems.graph.shortestpath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {
    private int v_size;   // No. of vertices
    private LinkedList<Node> adj[]; //Adjacency Lists

    Graph(int size) {
        v_size = size;
        adj = new LinkedList[size];
        for (int i = 0; i < size; ++i)
            adj[i] = new LinkedList();
    }

    public static void main(String args[]) {
        Graph g = new Graph(9);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);

        g.addEdge(1, 0, 4);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);

        g.addEdge(2, 1, 8);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 5, 4);

        g.addEdge(3, 2, 7);
        g.addEdge(3, 5, 14);
        g.addEdge(3, 4, 9);

        g.addEdge(4, 3, 9);
        g.addEdge(4, 5, 10);

        g.addEdge(5, 4, 10);
        g.addEdge(5, 3, 14);
        g.addEdge(5, 2, 4);
        g.addEdge(5, 6, 2);

        g.addEdge(6, 5, 2);
        g.addEdge(6, 8, 6);
        g.addEdge(6, 7, 1);

        g.addEdge(7, 6, 1);
        g.addEdge(7, 8, 7);
        g.addEdge(7, 1, 11);
        g.addEdge(7, 0, 8);

        g.addEdge(8, 2, 2);
        g.addEdge(8, 6, 6);
        g.addEdge(8, 7, 7);

        System.out.println(Arrays.toString(g.findMiniDisFrom(0)));
    }

    // Function to add an edge into the graph
    void addEdge(int u, int v, int weight) {
        Node node = new Node(v, weight);
        adj[u].add(node);
    }

    int[] findMiniDisFrom(int source) {
        boolean[] isVisited = new boolean[v_size];
        isVisited[source] = true;

        final int[] distance = new int[v_size];
        for (int i = 0; i < v_size; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        queue.offer(new Node(source, 0));

        while (!queue.isEmpty()) {
            final Node head = queue.poll();
            for (Node adj : adj[head.num]) {
                if (!isVisited[adj.num]) {
                    if (distance[head.num] + adj.weight < distance[adj.num]) {
                        distance[adj.num] = distance[head.num] + adj.weight;
                        queue.remove(adj);
                        queue.add(new Node(adj.num, distance[adj.num]));
                    }
                }
            }
            isVisited[head.num] = true;
        }

        return distance;
    }

    public static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return num == node.num;
        }

        @Override
        public int hashCode() {
            int result = num;
            result = 31 * result + weight;
            return result;
        }
    }
}
