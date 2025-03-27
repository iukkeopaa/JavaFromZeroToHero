package MyCollections;

import java.util.Arrays;

//题目描述
//小红有一个长度为n的数组a，他想从里面选一些数拿走使 得这些数求和结果最大。但小红受一些限制。
//具体的，每人个连续的数字中，小红就必须带走至少た个数，即每个长度为k的合法区间中都要存在至少一个数字被小红
//带走。小红想知道在受到限制的情况下，他最多能带走求和为多少的数字?
public class NumberSelection {
    public static int maxSum(int[] a, int k) {
        int n = a.length;
        // dp[i] 表示考虑前 i 个数时能得到的最大和
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // 尝试选取当前数字
            dp[i] = Math.max(dp[i], dp[i - 1] + a[i - 1]);
            // 确保每个长度为 k 的区间至少有一个数字被选中
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