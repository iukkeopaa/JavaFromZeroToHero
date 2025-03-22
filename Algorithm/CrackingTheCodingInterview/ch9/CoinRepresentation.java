package CrackingTheCodingInterview.ch9;

public class CoinRepresentation {
    public static int waysToChange(int n) {
        int[] coins = {25, 10, 5, 1};
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("用硬币组合出 " + n + " 分的表示法数量为: " + waysToChange(n));
    }
}    