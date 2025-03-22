package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class EggHardnessTest {
    public static int eggDrop(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        // 初始化：如果只有一层楼，只需要一次试验
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        // 初始化：如果只有一个鸡蛋，需要试验的次数等于楼层数
        for (int j = 1; j <= m; j++) {
            dp[1][j] = j;
        }

        // 填充 dp 数组
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    // 两种情况：鸡蛋碎了和鸡蛋没碎
                    int temp = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
                    dp[i][j] = Math.min(dp[i][j], temp);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int n = 2; // 鸡蛋数量
        int m = 10; // 楼层数量
        System.out.println("在最坏情况下，最少需要做 " + eggDrop(n, m) + " 次试验。");
    }
}    