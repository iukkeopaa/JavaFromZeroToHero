package CrackingTheCodingInterview.ch1;

public class cp7 {

    public void setZeros(int[][] matrix) {
        // 假设输入的数据都是合法的
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        // 记录值为0的元素所在行索引和列索引
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // 若行i或者列j有个元素为0，则将matrix[i][j]设置为0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 使用O(1)内存的解法
     *
     * @param matrix
     */
    public void setZeros2(int[][] matrix) {
        // 记录是否第0行要清零
        boolean row = false;
        // 记录是否第0列要清零
        boolean col = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                // 将第0行和第0列用来标记其它行和列是否要清零
                if (matrix[i][j] == 0) {
                    // 第j列要设置为0
                    matrix[0][j] = 0;
                    // 第i行要设置为0
                    matrix[i][0] = 0;

                    // 第0行要清零
                    if (i == 0) {
                        row = true;
                    }
                    // 第0列要清零
                    if (j == 0) {
                        col = true;
                    }
                }
            }
        }

        // 将第0列以外的列清零
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // 将第0行以外的行清零
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 将第0行清零
        if (row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        // 将第0列清零
        if (col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] rowHasZero = new boolean[rows];
        boolean[] colHasZero = new boolean[cols];

        // 遍历矩阵，标记哪些行和列包含 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowHasZero[i] = true;
                    colHasZero[j] = true;
                }
            }
        }

        // 根据标记，将相应的行和列置为 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowHasZero[i] || colHasZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        System.out.println("原始矩阵:");
        printMatrix(matrix);

        setZeroes(matrix);

        System.out.println("处理后的矩阵:");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}
