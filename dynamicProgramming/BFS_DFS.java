package codes.dynamicProgramming;
import java.util.*;

public class BFS_DFS {

    int V;
    LinkedList<Integer> adj[];

    BFS_DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS
    void BFS(int s) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int n : adj[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    // DFS
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        System.out.print("DFS Traversal: ");
        DFSUtil(v, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        BFS_DFS g = new BFS_DFS(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);

        g.BFS(0);
        g.DFS(0);
    }
}