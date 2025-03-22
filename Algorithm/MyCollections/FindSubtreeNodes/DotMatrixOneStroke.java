package MyCollections.FindSubtreeNodes;

import java.util.ArrayList;
import java.util.List;

//一笔画完，给定一个点阵，一笔连接所有的点。（有点类似一笔画完游戏）。
class Point1 {
    int x;
    int y;

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class DotMatrixOneStroke {
    private static int rows;
    private static int cols;
    private static boolean[][] visited;
    private static List<Point> path;

    public static List<Point> findPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        visited = new boolean[rows][cols];
        path = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(matrix, i, j, 0)) {
                    return path;
                }
            }
        }
        return null;
    }

    private static boolean dfs(int[][] matrix, int x, int y, int step) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y]) {
            return false;
        }

        visited[x][y] = true;
        path.add(new Point(x, y));

        if (step == rows * cols - 1) {
            return true;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (dfs(matrix, newX, newY, step + 1)) {
                return true;
            }
        }

        visited[x][y] = false;
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        List<Point> result = findPath(matrix);
        if (result != null) {
            for (Point point : result) {
                System.out.println(point);
            }
        } else {
            System.out.println("No valid path found.");
        }
    }
}    