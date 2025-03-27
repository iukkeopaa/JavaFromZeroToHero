package MyCollections;

import java.util.Scanner;

//题目内容
//小红拿到一棵n个结点的树，第i个点的权值为a。 现在，你需要求解，对于全部的连通块，它们内部中结点权值为奇数
//的结点数量之和是多少，由于答案可能很大,请将答案对(10”+7)取模后输出。
//她定义对于树上的两个点，如果它们相连，则称他们位于同一个连通块里。特别地，一个单独的点也可以构成一个连通
//连通块的大小即为连通块中节点的数量。
//输入描述
//第一行一个整数n(1 ≤n≤ 10”)，表示结点个数。
//第二行n个整数，第i个数为a(1 ≤ a ≤ 10°),表示一次权值。
//接下来n -1行，每行两个整数u,υ(1 ≤ u,υ ≤ n,u ≠ υ)，表示u,υ之间存在一条无向边。
//输出描述
//个整数，表示所有连通块内部中结点权值为奇数的结点数量之和，结果对109+7取模，
public class TreeConnectedBlocks {
    static final int MOD = (int) (1e9 + 7);
    static int[] parent;
    static int[] oddCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weights[i] = scanner.nextInt();
        }
        parent = new int[n + 1];
        oddCount = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            oddCount[i] = weights[i] % 2 == 1 ? 1 : 0;
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            union(u, v);
        }
        long totalOddCount = 0;
        for (int i = 1; i <= n; i++) {
            if (find(i) == i) {
                totalOddCount = (totalOddCount + oddCount[i]) % MOD;
            }
        }
        System.out.println(totalOddCount);
        scanner.close();
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            oddCount[rootX] += oddCount[rootY];
        }
    }
}    