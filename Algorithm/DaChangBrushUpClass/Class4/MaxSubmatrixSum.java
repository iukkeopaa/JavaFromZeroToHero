package DaChangBrushUpClass.Class4;


//返回一个二维数组中子矩阵最大累加和
//思路
// 1. 先固定上下边界，然后计算每列的累加和，得到一个一维数组
// 2. 然后在一维数组中求最大累加和，得到一个值
// 3. 然后在所有值中求最大值，得到结果



//给出一个具体的例子来解释算法

// 假设我们有以下的二维数组：
// 1 2 -3 4
// 5 -6 -7 8
// 9 -10 -11 12
// 我们要找到一个子矩阵的最大累加和。
// 1. 首先，我们固定上下边界，假设上下边界分别为第1行和第3行。那么我们可以得到一个一维数组：
// 1 2 -3 4
// 5 -6 -7 8
// 9 -10 -11 12
// 6 0 -14 16
// 2. 然后，我们在这个一维数组中求最大累加和。我们可以使用Kadane算法来解决这个问题。Kadane算法的基本思想是遍历数组，记录当前位置的最大累加和和全局最大累加和。
// 3. 最后，我们在所有的一维数组中求最大累加和，得到的结果就是子矩阵的最大累加和。

public class MaxSubmatrixSum {
    public static int maxSubmatrixSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int[] colSum = new int[cols];
            for (int j = i; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    colSum[k] += matrix[j][k];
                }
                int currentSum = maxSubArraySum(colSum);
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    private static int maxSubArraySum(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, -2, -3, 4},
            {5, -6, -7, 8},
            {9, -10, -11, 12}
        };
        int result = maxSubmatrixSum(matrix);
        System.out.println("子矩阵的最大累加和是: " + result);
    }
}    