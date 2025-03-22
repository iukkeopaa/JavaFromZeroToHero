package CrackingTheCodingInterview.ch4;

import java.util.*;

class Graph {
    private int V; // 顶点数
    private LinkedList<Integer> adj[]; // 邻接表

    // 构造函数
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // 添加边
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // 使用 BFS 检查从 s 到 d 是否存在路径
    boolean isReachable(int s, int d) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            int n;
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                n = i.next();
                if (n == d)
                    return true;
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int u = 1;
        int v = 3;
        if (g.isReachable(u, v))
            System.out.println("从 " + u + " 到 " + v + " 存在路径");
        else
            System.out.println("从 " + u + " 到 " + v + " 不存在路径");
    }
}    