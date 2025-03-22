package FantasticAlgorithms;

public class MatrixMultiplication {
    public static void main(String[] args) {
        // 定义第一个矩阵
        int[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6}
        };
        // 定义第二个矩阵
        int[][] matrixB = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        // 调用矩阵相乘的方法
        int[][] result = multiplyMatrices(matrixA, matrixB);

        // 打印结果矩阵
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        // 初始化结果矩阵
        int[][] result = new int[rowsA][colsB];

        // 矩阵相乘的核心逻辑
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}    