package MyCollections.FindSubtreeNodes.LongestIncreasingPath;

public class LongestIncreasingPath {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int maxPath = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLen = 1;
        for (int[] dir : DIRECTIONS) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[i][j]) {
                maxLen = Math.max(maxLen, 1 + dfs(matrix, newRow, newCol, memo));
            }
        }
        memo[i][j] = maxLen;
        return maxLen;
    }

    public static void main(String[] args) {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println("最长上升路径的长度是: " + solution.longestIncreasingPath(matrix));
    }
}    