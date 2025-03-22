package MyCollections.FindSubtreeNodes.ArrayMagicOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMagicOperation {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int n = array.length;
        // 假设所有元素之和为 sum，那么魔法值的范围是 [-sum, sum]
        int sum = Arrays.stream(array).sum();
        // dp[i][j] 表示处理到第 i 个数时，魔法值为 j 的最小绝对值
        int[][] dp = new int[n + 1][2 * sum + 1];
        // 初始化 dp 数组
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // 初始魔法值为 0
        dp[0][sum] = 0;

        // 存储操作路径
        String[][] path = new String[n + 1][2 * sum + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (dp[i][j] != Integer.MAX_VALUE) {
                    // 加当前数
                    int upIndex = j + array[i];
                    if (dp[i + 1][upIndex] > dp[i][j]) {
                        dp[i + 1][upIndex] = dp[i][j];
                        path[i + 1][upIndex] = "UP";
                    }
                    // 减当前数
                    int downIndex = j - array[i];
                    if (dp[i + 1][downIndex] > dp[i][j]) {
                        dp[i + 1][downIndex] = dp[i][j];
                        path[i + 1][downIndex] = "DOWN";
                    }
                }
            }
        }

        // 找到最小绝对值
        int minAbs = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int j = 0; j <= 2 * sum; j++) {
            int absValue = Math.abs(j - sum);
            if (dp[n][j] != Integer.MAX_VALUE && absValue < minAbs) {
                minAbs = absValue;
                minIndex = j;
            }
        }

        System.out.println("最小魔法值的绝对值: " + minAbs);

        // 回溯操作路径
        List<String> operations = new ArrayList<>();
        int currentIndex = minIndex;
        for (int i = n; i > 0; i--) {
            operations.add(0, path[i][currentIndex]);
            if ("UP".equals(path[i][currentIndex])) {
                currentIndex -= array[i - 1];
            } else {
                currentIndex += array[i - 1];
            }
        }
        System.out.println("对应的操作: " + String.join(" ", operations));
    }
}    