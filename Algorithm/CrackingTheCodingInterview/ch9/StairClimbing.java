package CrackingTheCodingInterview.ch9;

public class StairClimbing {
    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i >= 2) {
                dp[i] += dp[i - 2];
            }
            if (i >= 3) {
                dp[i] += dp[i - 3];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("小孩上 " + n + " 阶楼梯的方式有 " + climbStairs(n) + " 种。");
    }
}    