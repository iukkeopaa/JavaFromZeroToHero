package TheLawofProgrammingAlgorithmsAndInterviewTips.Dp.Questions;

public class LongestCommonSubsequence {
    public static String longestCommonSubsequence(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[][] dp = new int[m + 1][n + 1];

        // 填充动态规划表格
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 回溯构建最长公共子序列
        StringBuilder result = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (arr1[i - 1] == arr2[j - 1]) {
                result.insert(0, arr1[i - 1]);
                result.insert(0, ",");
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        if (result.length() > 0) {
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 5};
        int[] arr2 = {2, 4, 5, 5, 7, 6};
        String lcs = longestCommonSubsequence(arr1, arr2);
        System.out.println("最长公共子序列是: " + lcs);
    }
}    