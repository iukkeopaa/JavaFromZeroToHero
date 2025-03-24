package MyCollections.FindSubtreeNodes.LongestSubstringWithEqualAB;

public class LongestSubstringWithEqualAB {
    public static int longestSubstring(String s) {
        int n = s.length();
        // 二维数组 dp 用于存储子串的状态
        int[][] dp = new int[n][n];
        int maxLength = 0;

        // 初始化单个字符的情况
        for (int i = 0; i < n; i++) {
            dp[i][i] = s.charAt(i) == 'a' ? 1 : -1;
        }

        // 枚举子串的长度
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // 根据状态转移方程更新 dp 数组
                dp[i][j] = dp[i][j - 1] + (s.charAt(j) == 'a' ? 1 : -1);
                if (dp[i][j] == 0) {
                    maxLength = Math.max(maxLength, len);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abaaabbbaaab";
        System.out.println("最长子串长度: " + longestSubstring(s));
        System.out.println("最长子串: " + s.substring(0, longestSubstring(s)));
    }
}    