package MyCollections;

import java.util.*;

//题目内容
//小红拿到一棵树，结点总数为n，根节点为1
//是又每个点的权值为到结点1的边数。
//现在小红可以选择一个非1号结点，使得以该结点为根节点的子树成为1号结点的子结点
//求整棵树的最小权值之和是多少?
//输入描述
//第一行一个整数n(1 ≤n ≤ 2 x 10'),表示树的结点总数。
//接下来n - 1行，每行两个整数u,u(1 < u,u < n),表示u和u之间有一条边。
//输出描述
//个整数，表示整棵树的最小权值之和。
public class TreeMinWeightSum {
    static int n;
    static List<List<Integer>> graph;
    static int[] depth;
    static int[] subtreeSize;
    static int totalWeight = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        depth = new int[n + 1];
        subtreeSize = new int[n + 1];
        dfs(1, 0);

        int minWeight = totalWeight;
        for (int i = 2; i <= n; i++) {
            int newWeight = totalWeight - subtreeSize[i] * (depth[i] - 1);
            minWeight = Math.min(minWeight, newWeight);
        }
        System.out.println(minWeight);
    }

    static void dfs(int node, int parent) {
        depth[node] = depth[parent] + 1;
        subtreeSize[node] = 1;
        totalWeight += depth[node];
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
                subtreeSize[node] += subtreeSize[child];
            }
        }
    }
}
    