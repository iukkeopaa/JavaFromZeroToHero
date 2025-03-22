package TheLawofProgrammingAlgorithmsAndInterviewTips.Dp.Questions;

import java.util.Arrays;

public class DominoTiling {
    private static final int MAXN = 11;
    private static int n, m;
    private static long[][] dp = new long[MAXN][1 << MAXN];

    public static void main(String[] args) {
        n = 3;
        m = 2;
        for (int i = 0; i < MAXN; i++) {
            Arrays.fill(dp[i], -1);
        }
        long result = solve(0, 0);
        System.out.println("铺放方法数: " + result);
    }

    private static long solve(int row, int state) {
        if (row == n) {
            return state == 0 ? 1 : 0;
        }
        if (dp[row][state] != -1) {
            return dp[row][state];
        }
        dp[row][state] = 0;
        dfs(row, 0, state, 0);
        return dp[row][state];
    }

    private static void dfs(int row, int col, int curState, int nextState) {
        if (col == m) {
            dp[row][curState] += solve(row + 1, nextState);
            return;
        }
        if ((curState & (1 << col)) != 0) {
            dfs(row, col + 1, curState, nextState);
        } else {
            // 竖着放
            if (row + 1 < n) {
                dfs(row, col + 1, curState, nextState | (1 << col));
            }
            // 横着放
            if (col + 1 < m && (curState & (1 << (col + 1))) == 0) {
                dfs(row, col + 2, curState, nextState);
            }
        }
    }
}    