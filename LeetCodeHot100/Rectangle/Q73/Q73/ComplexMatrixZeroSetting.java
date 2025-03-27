package Rectangle.Q73.Q73;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComplexMatrixZeroSetting {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 用于存储值为 0 的元素所在的行索引
        List<Integer> zeroRows = new ArrayList<>();
        // 用于存储值为 0 的元素所在的列索引
        List<Integer> zeroCols = new ArrayList<>();

        // 第一次遍历矩阵，记录值为 0 的元素的行和列索引
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        // 用于记录已经处理过的行
        Set<Integer> processedRows = new HashSet<>();
        // 用于记录已经处理过的列
        Set<Integer> processedCols = new HashSet<>();

        // 根据记录的行索引将对应行的元素置为 0
        for (int row : zeroRows) {
            if (!processedRows.contains(row)) {
                for (int j = 0; j < n; j++) {
                    matrix[row][j] = 0;
                }
                processedRows.add(row);
            }
        }

        // 根据记录的列索引将对应列的元素置为 0
        for (int col : zeroCols) {
            if (!processedCols.contains(col)) {
                for (int i = 0; i < m; i++) {
                    matrix[i][col] = 0;
                }
                processedCols.add(col);
            }
        }
    }

    public static void main(String[] args) {
        ComplexMatrixZeroSetting solution = new ComplexMatrixZeroSetting();
        int[][] matrix = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };
        solution.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}