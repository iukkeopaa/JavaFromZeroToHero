package MyCollections.FindSubtreeNodes;

import java.util.ArrayList;
import java.util.List;

public class MatrixOperationsWithList {
    // 矩阵加法
    public static List<List<Integer>> add(List<List<Integer>> matrix1, List<List<Integer>> matrix2) {
        int rows = matrix1.size();
        int cols = matrix1.get(0).size();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(matrix1.get(i).get(j) + matrix2.get(i).get(j));
            }
            result.add(row);
        }
        return result;
    }

    // 矩阵乘法
    public static List<List<Integer>> multiply(List<List<Integer>> matrix1, List<List<Integer>> matrix2) {
        int rows1 = matrix1.size();
        int cols1 = matrix1.get(0).size();
        int cols2 = matrix2.get(0).size();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols2; j++) {
                int sum = 0;
                for (int k = 0; k < cols1; k++) {
                    sum += matrix1.get(i).get(k) * matrix2.get(k).get(j);
                }
                row.add(sum);
            }
            result.add(row);
        }
        return result;
    }

    // 打印矩阵
    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix1 = new ArrayList<>();
        matrix1.add(List.of(1, 2));
        matrix1.add(List.of(3, 4));

        List<List<Integer>> matrix2 = new ArrayList<>();
        matrix2.add(List.of(5, 6));
        matrix2.add(List.of(7, 8));

        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        System.out.println("Matrix 2:");
        printMatrix(matrix2);

        List<List<Integer>> sum = add(matrix1, matrix2);
        System.out.println("Sum of matrices:");
        printMatrix(sum);

        List<List<Integer>> product = multiply(matrix1, matrix2);
        System.out.println("Product of matrices:");
        printMatrix(product);
    }
}