package TheLawofProgrammingAlgorithmsAndInterviewTips.Dp.Questions;

import java.util.Scanner;

public class BlockWallBuilding {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();
        long result = calculateWays(k, n);
        System.out.println(result);
    }

    public static long calculateWays(int k, int n) {
        int length = 1 << n;
        long[][] dp = new long[length + 1][1 << k];
        dp[0][0] = 1;

        for (int i = 0; i < length; i++) {
            for (int state = 0; state < (1 << k); state++) {
                if (dp[i][state] == 0) {
                    continue;
                }
                long ways = dp[i][state];
                dfs(i, state, 0, 0, ways, k, length, dp);
            }
        }

        return dp[length][0];
    }

    private static void dfs(int pos, int preState, int curState, int layer, long ways, int k, int length, long[][] dp) {
        if (layer == k) {
            dp[pos + 1][curState] = (dp[pos + 1][curState] + ways) % MOD;
            return;
        }

        if ((preState & (1 << layer)) != 0) {
            dfs(pos, preState, curState, layer + 1, ways, k, length, dp);
        } else {
            // 放 1x1x1 木块
            dfs(pos, preState, curState | (1 << layer), layer + 1, ways, k, length, dp);

            // 放 1x2x1 木块
            if (layer + 1 < k && (preState & (1 << (layer + 1))) == 0) {
                dfs(pos, preState, curState | (3 << layer), layer + 2, ways, k, length, dp);
            }

            // 放 2x1x1 木块
            if (pos + 1 < length) {
                dfs(pos, preState | (1 << layer), curState, layer + 1, ways, k, length, dp);
            }
        }
    }
}    