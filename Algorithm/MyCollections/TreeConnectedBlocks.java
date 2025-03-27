package MyCollections;

import java.util.Scanner;

//��Ŀ����
//С���õ�һ��n������������i�����ȨֵΪa�� ���ڣ�����Ҫ��⣬����ȫ������ͨ�飬�����ڲ��н��ȨֵΪ����
//�Ľ������֮���Ƕ��٣����ڴ𰸿��ܴܺ�,�뽫�𰸶�(10��+7)ȡģ�������
//������������ϵ������㣬��������������������λ��ͬһ����ͨ����ر�أ�һ�������ĵ�Ҳ���Թ���һ����ͨ
//��ͨ��Ĵ�С��Ϊ��ͨ���нڵ��������
//��������
//��һ��һ������n(1 ��n�� 10��)����ʾ��������
//�ڶ���n����������i����Ϊa(1 �� a �� 10��),��ʾһ��Ȩֵ��
//������n -1�У�ÿ����������u,��(1 �� u,�� �� n,u �� ��)����ʾu,��֮�����һ������ߡ�
//�������
//����������ʾ������ͨ���ڲ��н��ȨֵΪ�����Ľ������֮�ͣ������109+7ȡģ��
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