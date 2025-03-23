package DaChangBrushUpClass.class1.class2.class1.Class1;

//给定一个二维数组matrix，你可以从任何位置出发，走向上、下、左、右四个方向，返回能走出来的最长的递增链长度
public class LongestIncreasingChain {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int maxLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j, memo));
            }
        }
        return maxLength;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxPath = 1;
        for (int[] dir : DIRECTIONS) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[i][j]) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix, newRow, newCol, memo));
            }
        }
        memo[i][j] = maxPath;
        return maxPath;
    }

    public static int longestIncreasingPath1(int[][] matrix) {
        int ans = 0;
        int N = matrix.length;
        int M = matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, process1(matrix, i, j));
            }
        }
        return ans;
    }

    // 从m[i][j]开始走，走出来的最长递增链，返回！
    public static int process1(int[][] m, int i, int j) {
        int up = i > 0 && m[i][j] < m[i - 1][j] ? process1(m, i - 1, j) : 0;
        int down = i < (m.length - 1) && m[i][j] < m[i + 1][j] ? process1(m, i + 1, j) : 0;
        int left = j > 0 && m[i][j] < m[i][j - 1] ? process1(m, i, j - 1) : 0;
        int right = j < (m[0].length - 1) && m[i][j] < m[i][j + 1] ? process1(m, i, j + 1) : 0;
        return Math.max(Math.max(up, down), Math.max(left, right)) + 1;
    }

    public static int longestIncreasingPath2(int[][] matrix) {
        int ans = 0;
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, process2(matrix, i, j, dp));
            }
        }
        return ans;
    }

    // 从m[i][j]开始走，走出来的最长递增链，返回！
    public static int process2(int[][] m, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        // (i,j)不越界
        int up = i > 0 && m[i][j] < m[i - 1][j] ? process2(m, i - 1, j, dp) : 0;
        int down = i < (m.length - 1) && m[i][j] < m[i + 1][j] ? process2(m, i + 1, j, dp) : 0;
        int left = j > 0 && m[i][j] < m[i][j - 1] ? process2(m, i, j - 1, dp) : 0;
        int right = j < (m[0].length - 1) && m[i][j] < m[i][j + 1] ? process2(m, i, j + 1, dp) : 0;
        int ans = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        dp[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(longestIncreasingPath(matrix));
    }
}    