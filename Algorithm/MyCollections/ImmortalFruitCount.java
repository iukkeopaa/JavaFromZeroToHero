package MyCollections;

import java.util.ArrayList;
import java.util.List;

//�����޸�����һ�ý�ľ����˵���½�ľ���ɵ���ʵ�Ϳ��Եõ����޾����١������壬�ɱ�Ϊ�����֡���С���Ƕ����֣���
//���������ҵ���ʵ�� ��ľ��һ���м����ڵ���и������ڵ���Ϊ1~n�����ڵ�Ϊ
//���ڱ��Ϊi�Ľڵ㣬f(i)��ʾ��iΪ���������У��ڵ�����i�����ӵĽڵ������
//��ľ����ʵ���������ǡ�"f(i)����С����֪����ľ����ʵ�������Ƕ��١�
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
        System.out.println("��ľ����ʵ��������: " + total);
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
    