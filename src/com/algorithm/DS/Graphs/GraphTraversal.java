package com.algorithm.DS.Graphs;

public class GraphTraversal {
    public static void main(String[] args) {

        AdjacencyListImplementation.Graph<Integer> g = new AdjacencyListImplementation.Graph<Integer>();
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);
        System.out.println("The Graph is :\n" + g.toString());
        g.BFS(0);
        g.DFS(0);
        g.recursiveBFS(0);
    }


}
