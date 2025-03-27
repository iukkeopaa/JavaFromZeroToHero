package MyCollections;

import java.util.Arrays;

//��Ŀ����
//С����һ������Ϊn������a�����������ѡһЩ������ʹ ����Щ����ͽ����󡣵�С����һЩ���ơ�
//����ģ�ÿ�˸������������У�С��ͱ���������٤���������ÿ������Ϊk�ĺϷ������ж�Ҫ��������һ�����ֱ�С��
//���ߡ�С����֪�����ܵ����Ƶ�����£�������ܴ������Ϊ���ٵ�����?
public class NumberSelection {
    public static int maxSum(int[] a, int k) {
        int n = a.length;
        // dp[i] ��ʾ����ǰ i ����ʱ�ܵõ�������
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // ����ѡȡ��ǰ����
            dp[i] = Math.max(dp[i], dp[i - 1] + a[i - 1]);
            // ȷ��ÿ������Ϊ k ������������һ�����ֱ�ѡ��
            for (int j = Math.max(0, i - k); j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + a[i - 1]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(maxSum(a, k));
    }
}    