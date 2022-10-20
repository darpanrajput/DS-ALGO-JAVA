package com.algorithm.DS.Graphs;

public class GraphMatrixImplementation {
    public static void main(String[] args) {
        GraphMatrix graphMatrix = new GraphMatrix(5);

        graphMatrix.addEdge(1, 2, true);
        graphMatrix.addEdge(2, 3, true);
        graphMatrix.addEdge(3, 4, true);
        graphMatrix.addEdge(4, 0, true);
        graphMatrix.addEdge(1, 3, true);
        graphMatrix.addEdge(1, 4, false);
        System.out.println(graphMatrix);
        graphMatrix.hasEdge(4, 1);
    }

    private static class GraphMatrix {
        private static int[][] adjMatrix;

        public GraphMatrix(int nodes) {
            adjMatrix = new int[nodes][nodes];
        }

        private void addEdge(int u, int v, boolean bidirectional) {
            adjMatrix[u][v] = 1;
            if (bidirectional) {
                adjMatrix[v][u] = 1;
            }

        }

        private void hasEdge(int u, int v) {
            if (adjMatrix[u][v] == 1) {
                System.out.println("there is an edge between " + u + " and " + v);
            } else {
                System.out.println("there is NO edge between " + u + " and " + v);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < adjMatrix.length; row++) {
                for (int col = 0; col < adjMatrix.length; col++) {
                    sb.append(adjMatrix[row][col]).append("\t");
                }
                sb.append("\n");
            }

            return sb.toString();
        }

    }
}
