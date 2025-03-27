package MyCollections;

import java.util.ArrayList;
import java.util.List;

//仙舟罗浮上有一棵建木，据说服下建木生成的神实就可以得到“无尽形寿”的身体，蜕变为长生种。米小游是短生种，因
//此她很想找到神实。 建木是一棵有几个节点的有根树，节点编号为1~n，根节点为
//对于编号为i的节点，f(i)表示以i为根的子树中，节点编号是i的因子的节点个数。
//建木上神实的总数就是〉"f(i)，米小游想知道建木上神实的总数是多少。
public class ImmortalFruitCount {
    static int[] f;
    static List<List<Integer>> tree;

    public static void main(String[] args) {
        int n = 5;
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(2, 5);

        f = new int[n + 1];
        dfs(1, -1);

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += f[i];
        }
        System.out.println("建木上神实的总数是: " + total);
    }

    static void addEdge(int u, int v) {
        tree.get(u).add(v);
        tree.get(v).add(u);
    }

    static void dfs(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node);
                if (node % child == 0) {
                    f[node]++;
                }
                f[node] += f[child];
            }
        }
    }
}
    