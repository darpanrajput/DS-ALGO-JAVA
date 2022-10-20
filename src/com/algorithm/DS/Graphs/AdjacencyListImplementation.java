package com.algorithm.DS.Graphs;

import java.util.*;

public class AdjacencyListImplementation {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<Integer>();
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);
        System.out.println("The Graph is :\n" + g.toString());
        g.getVertexCount();
        g.getEdgeCount();
        g.hasEdge(2, 7);
        g.hasEdge(0, 4);
        g.hasVertex(5);
        g.hasVertex(3);
    }

    static class Graph<T> {
        private Map<T, List<T>> map = new HashMap<>();
        private boolean bi;


        public void addEdge(T source, T destination, boolean bidirectional) {
            bi = bidirectional;
            if (!map.containsKey(source)) map.put(source, new LinkedList<T>());
            if (!map.containsKey(destination)) map.put(destination, new LinkedList<T>());

            map.get(source).add(destination);
            if (bidirectional) {
                map.get(destination).add(source);
            }
        }

        public void getVertexCount() {
            int count;
            count = map.keySet().size();
            System.out.println("The Graph has " + count + " vertex");
        }

        public void getEdgeCount() {
            int count = 0;
            for (T vertex : map.keySet()) {
                count += map.get(vertex).size();
            }
            if (bi) count = count / 2;
            System.out.println("the graph has " + count + " edges");
        }

        public void hasVertex(T s) {
            String str = "the graph has vertex ";
            if (map.containsKey(s)) {
                System.out.println(str + s);
            } else {
                System.out.println("there is no vertex like " + s);
            }
        }

        public void hasEdge(T s, T d) {
            if (map.get(s).contains(d)) {
                System.out.println("there is an edge between " + s + " and " + d);
            } else {
                System.out.println("there is no edge between " + s + " and " + d);
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (T s : map.keySet()) {
                coverWithBraces(stringBuilder, s).append(":");
                for (T d : map.get(s)) {
                    stringBuilder.append(d).append(" ");
                }
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }

        private StringBuilder coverWithBraces(StringBuilder stringBuilder, T s) {
            return stringBuilder.append("[").append(s).append("]");
        }



        /*Traversal*/

        public void BFS(T startNode) {
            //uses concept of FIFO
            System.out.println("BFS");
            Set<T> set = new HashSet<>();
            LinkedList<T> queue = new LinkedList<>();
            queue.add(startNode);
            set.add(startNode);
            while (!queue.isEmpty()) {
                T node = queue.poll();
                System.out.print(node + "->");
                for (T item : map.get(node)) {
                    if (!set.contains(item)) {
                        queue.add(item);
                        set.add(item);
                    }
                }
            }
        }

        public void DFS(T startNode) {
            //uses the concept of LIFO
            System.out.println("\nDFS");
            Set<T> set = new HashSet<>();
            Stack<T> stack = new Stack<>();
            stack.push(startNode);
            set.add(startNode);
            while (!stack.isEmpty()) {
                T node = stack.pop();
                System.out.print(node + "->");
                for (T item : map.get(node)) {
                    if (!set.contains(item)) {
                        stack.push(item);
                        set.add(item);
                    }
                }
            }
        }

        /*Recursive graph traversal*/

        public void recursiveBFS(T start) {
            System.out.println("recursive BFS");
            Set<T> set = new HashSet<>();
            //concept of FIFO;
            Queue<T> queue = new ArrayDeque<>();
            recursiveBFSUtil(start, set, queue);

        }

        private void recursiveBFSUtil(T startNode, Set<T> isVisited, Queue<T> queue) {
            isVisited.add(startNode);
            System.out.print(startNode + "->");
            for (T item : map.get(startNode)) {
                if (!isVisited.contains(item)) {
                    isVisited.add(item);
                    queue.add(item);
                }
            }
            while (!queue.isEmpty()) {
                recursiveBFSUtil(queue.poll(), isVisited, queue);
            }

        }

        /*recursive DFS */

        public void recursiveDFS(T start) {
            System.out.println("\nRecursive DFS ");
            Set<T> isVisited = new HashSet<>();
            recursiveDFSUtil(start, isVisited);
        }

        public void recursiveDFSUtil(T startNode, Set<T> isVisited) {
            isVisited.add(startNode);
            System.out.print(startNode + "->");
            for (T node : map.get(startNode)) {
                if (!isVisited.contains(node)) {
                    isVisited.add(node);
                    recursiveDFSUtil(node, isVisited);
                }
            }
        }

    }
}
