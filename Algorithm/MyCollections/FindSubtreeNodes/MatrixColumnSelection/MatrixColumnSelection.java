package MyCollections.FindSubtreeNodes.MatrixColumnSelection;

public class MatrixColumnSelection {
    public static int minSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // dp 数组，dp[i][j] 表示前 i 列，第 i 列选择第 j 行元素时的最小绝对值和
        int[][] dp = new int[cols][rows];

        // 初始化第一列的 dp 值
        for (int j = 0; j < rows; j++) {
            dp[0][j] = 0;
        }

        // 从第二列开始遍历
        for (int i = 1; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // 遍历上一列的所有行
                for (int k = 0; k < rows; k++) {
                    int currentSum = dp[i - 1][k] + Math.abs(matrix[i][j] - matrix[i - 1][k]);
                    dp[i][j] = Math.min(dp[i][j], currentSum);
                }
            }
        }

        // 找到最后一列的最小绝对值和
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < rows; j++) {
            min = Math.min(min, dp[cols - 1][j]);
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int result = minSum(matrix);
        System.out.println("最小绝对值和: " + result);
    }
}    