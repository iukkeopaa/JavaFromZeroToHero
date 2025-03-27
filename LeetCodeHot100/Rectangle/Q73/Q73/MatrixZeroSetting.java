package Rectangle.Q73.Q73;

public class MatrixZeroSetting {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // 检查第一行是否有 0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // 检查第一列是否有 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // 使用第一行和第一列来标记哪些行和列需要置 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据第一行和第一列的标记来置 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第一行
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // 处理第一列
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;   // 标记首行是否有0元素
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && matrix[i][j] == 0){
                    firstRow = true;    // 首行出现0元素，用标志位标记
                }else if(matrix[i][j] == 0){
                    matrix[0][j] = 0;   // 非首行出现0元素，将对应的列首置为0，说明该列要置为0
                    matrix[i][0] = 0;   // 将对应的行首置为0，说明该行要置为0
                }
            }
        }
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                // 从最后一个元素反向遍历，避免行首和列首的信息被篡改
                if(i == 0 && firstRow){
                    matrix[i][j] =0;    // 首行元素是否置为0看标志位
                }else if(i != 0 && (matrix[i][0] == 0 || matrix[0][j] == 0)){
                    matrix[i][j] = 0;   // 非首行元素是否置为0看行首和列首是否为0
                }
            }
        }
    }




    public static void main(String[] args) {
        MatrixZeroSetting solution = new MatrixZeroSetting();
        int[][] matrix = {
            {1, 2, 0, 4},
            {5, 6, 7, 8},
            {9, 0, 11, 12},
                {13, 14, 15, 16}
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
//0 0 0 0
//5 0 0 8
//0 0 0 0
//13 0 0 16