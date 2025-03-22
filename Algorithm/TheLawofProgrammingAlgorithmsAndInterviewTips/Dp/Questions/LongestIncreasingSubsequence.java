package TheLawofProgrammingAlgorithmsAndInterviewTips.Dp.Questions;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        // 初始化 dp 数组，每个元素初始值为 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 1, 2, 8};
        System.out.println("最长递增子序列的长度是: " + lengthOfLIS(nums));
    }
}    