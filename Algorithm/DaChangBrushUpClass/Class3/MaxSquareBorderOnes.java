package DaChangBrushUpClass.Class3;

//给定一个只有0和1组成的二维数组，返回边框全是1（内部无所谓）的最大正方形面积
public class MaxSquareBorderOnes {
    public static int largest1BorderedSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxSide = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    for (int side = 1; i + side <= rows && j + side <= cols; side++) {
                        if (isValidSquare(grid, i, j, side)) {
                            maxSide = Math.max(maxSide, side);
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }

    private static boolean isValidSquare(int[][] grid, int x, int y, int side) {
        // 检查上边
        for (int j = y; j < y + side; j++) {
            if (grid[x][j] != 1) {
                return false;
            }
        }
        // 检查下边
        for (int j = y; j < y + side; j++) {
            if (grid[x + side - 1][j] != 1) {
                return false;
            }
        }
        // 检查左边
        for (int i = x; i < x + side; i++) {
            if (grid[i][y] != 1) {
                return false;
            }
        }
        // 检查右边
        for (int i = x; i < x + side; i++) {
            if (grid[i][y + side - 1] != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println("最大正方形面积: " + largest1BorderedSquare(grid));
    }
}    