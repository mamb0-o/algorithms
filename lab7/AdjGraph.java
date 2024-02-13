package A01182685.bcit.ca;

import java.util.ArrayDeque;
import java.util.Queue;

public class AdjGraph {

    private int matrix[][];
    private boolean directed = false;
    private int[] visited;

    public AdjGraph(int num) {
        matrix = new int[num][num];
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int[] row : matrix) {
            for (int val : row) {
                result.append(val).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public void addEdge(int x, int y) {
        matrix[x][y] = 1;
        if (!directed) {
            matrix[y][x] = 1;
        }
    }

    public int degree(int x) {
        int degree = 0;
        for (int i = 0; i < matrix.length; i++) {
            degree += matrix[x][i];
        }
        return degree;
    }

    public int inDegree(int vert) {
        int in = 0;
        for (int i = 0; i < matrix.length; i++) {
            in += matrix[i][vert];
        }
        return in;
    }

    public int outDegree(int vert) {
        int out = 0;
        for (int i = 0; i < matrix.length; i++) {
            out += matrix[vert][i];
        }
        return out;
    }

    public void DFS() {
        visited = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
    }

    public void dfs(int y) {
        System.out.println("Visiting vertex: " + y);
        visited[y] = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[y][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }

    public void BFS() {
        visited = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (visited[i] == 0) {
                bfs(i);
            }
        }
    }

    public void bfs(int y) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(y);
        visited[y] = 1;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.println("Visiting vertex: " + vertex);
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[vertex][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
