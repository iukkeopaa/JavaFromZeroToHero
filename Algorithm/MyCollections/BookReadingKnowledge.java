package MyCollections;

//多多很喜欢读书，现在多多有一本书，书有n页，每读完一页，多多都可以获得ai的知识量。正常情况下，多多每分钟
//可以读完一页，但是多多还有一个能力，可以在一分钟内读完连续两页的内容，只不过能获取的知识量只有正常读产两
//火小识量之和的二分之一。现在多多只有m分钟的时间用来读完这本书，请你告诉多多他最多可以获得多少的知识。
public class BookReadingKnowledge {

    public static int maxKnowledge(int[] a, int m) {
        int n = a.length;
        // dp[i][j] 表示读到第 i 页，花费 j 分钟时获得的最大知识量
        int[][] dp = new int[n + 2][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 正常读一页
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + a[i]);
                // 读连续两页
                if (i + 1 < n) {
                    dp[i + 2][j + 1] = Math.max(dp[i + 2][j + 1], dp[i][j] + (a[i] + a[i + 1]) / 2);
                }
            }
        }

        int ans = 0;
        // 遍历最后一页不同时间花费的情况，找出最大值
        for (int j = 0; j <= m; j++) {
            ans = Math.max(ans, dp[n][j]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int m = 3;
        System.out.println("多多最多可以获得的知识量是: " + maxKnowledge(a, m));
    }
}    