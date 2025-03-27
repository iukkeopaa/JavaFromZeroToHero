package MyCollections;

import java.util.*;

//��Ŀ����
//С���õ�һ�������������Ϊn�����ڵ�Ϊ1
//����ÿ�����ȨֵΪ�����1�ı�����
//����С�����ѡ��һ����1�Ž�㣬ʹ���Ըý��Ϊ���ڵ��������Ϊ1�Ž����ӽ��
//������������СȨֵ֮���Ƕ���?
//��������
//��һ��һ������n(1 ��n �� 2 x 10'),��ʾ���Ľ��������
//������n - 1�У�ÿ����������u,u(1 < u,u < n),��ʾu��u֮����һ���ߡ�
//�������
//����������ʾ����������СȨֵ֮�͡�
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
    