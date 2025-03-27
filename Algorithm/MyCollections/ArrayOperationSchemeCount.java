package MyCollections;

import java.util.Arrays;

//小红有一个数组，她需要对数组操作
//n
//?
//1
//n?1 次，每次操作有两种选择：
//1. 选择数组的最后两个数，记
//x
//x 和
//y
//y，将它们从数组中删除，然后将
//x
//+
//y
//x+y 的个位数放回数组的最后。
//2. 选择数组的最后两个数，记
//x
//x 和
//y
//y，将它们从数组中删除，然后将
//x
//×
//y
//x×y 的个位数放回数组的最后。
public class ArrayOperationSchemeCount {
    private static final int MOD = (int) (1e9 + 7);

    public static int[] calculateResult(int[] arr) {
        int n = arr.length;
        // dp[i][j][k] 表示子数组 arr[i...j] 操作后结果为 k 的方案数
        int[][][] dp = new int[n][n][10];

        // 初始化单个元素的情况
        for (int i = 0; i < n; i++) {
            dp[i][i][arr[i]] = 1;
        }

        // 枚举区间长度
        for (int len = 2; len <= n; len++) {
            // 枚举区间起点
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // 枚举分割点
                for (int k = i; k < j; k++) {
                    for (int x = 0; x < 10; x++) {
                        for (int y = 0; y < 10; y++) {
                            if (dp[i][k][x] > 0 && dp[k + 1][j][y] > 0) {
                                int sum = (x + y) % 10;
                                int product = (x * y) % 10;
                                dp[i][j][sum] = (int) ((dp[i][j][sum] + (long) dp[i][k][x] * dp[k + 1][j][y]) % MOD);
                                dp[i][j][product] = (int) ((dp[i][j][product] + (long) dp[i][k][x] * dp[k + 1][j][y]) % MOD);
                            }
                        }
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] result = calculateResult(arr);
        System.out.println(Arrays.toString(result));
    }
}    