package CrackingTheCodingInterview.ch9;

import java.util.ArrayList;
import java.util.List;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class RobotPath {

    // 计算无禁区时从 (0, 0) 到 (X, Y) 的走法数量
    public static int countPaths(int X, int Y) {
        int[][] dp = new int[X + 1][Y + 1];
        for (int i = 0; i <= X; i++) {
            for (int j = 0; j <= Y; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[X][Y];
    }

    // 在有禁区的情况下找出一条从左上角到右下角的路径
    public static List<Point> findPath(boolean[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] || grid[rows - 1][cols - 1]) {
            return null;
        }
        List<Point> path = new ArrayList<>();
        if (findPathHelper(grid, rows - 1, cols - 1, path)) {
            return path;
        }
        return null;
    }

    private static boolean findPathHelper(boolean[][] grid, int row, int col, List<Point> path) {
        if (row < 0 || col < 0 || grid[row][col]) {
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);
        if (isAtOrigin || findPathHelper(grid, row - 1, col, path) || findPathHelper(grid, row, col - 1, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int X = 3;
        int Y = 3;
        System.out.println("无禁区时从 (0, 0) 到 (" + X + ", " + Y + ") 的走法数量: " + countPaths(X, Y));

        boolean[][] grid = {
                {false, false, false, false},
                {false, true, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };
        List<Point> path = findPath(grid);
        if (path != null) {
            System.out.println("有禁区时找到的路径:");
            for (Point p : path) {
                System.out.println(p);
            }
        } else {
            System.out.println("有禁区时未找到路径。");
        }
    }
}    