package CrackingTheCodingInterview.ch1;

public class cp6 {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 反转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public void rotate2(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = layer; i < last; i++) {
                int offset = i - first;
                // 存储上边
                int top = matrix[first][i];
                // 左到上
                matrix[first][i] = matrix[last - offset][first];
                // 下到左
                matrix[last - offset][first] = matrix[last][last - offset];
                // 右到下
                matrix[last][last - offset] = matrix[i][last];
                // 上到右
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("原始矩阵:");
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("旋转 90 度后的矩阵:");
        printMatrix(matrix);
    }
}
