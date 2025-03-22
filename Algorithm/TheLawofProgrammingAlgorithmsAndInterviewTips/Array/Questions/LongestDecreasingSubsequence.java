package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.Arrays;

public class LongestDecreasingSubsequence {
    public static int lengthOfLDS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // dp[i] 表示以 nums[i] 结尾的最长递减子序列的长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 3, 2, 5, 4, 3, 2};
        int result = lengthOfLDS(nums);
        System.out.println("最长递减子序列的长度是: " + result);
    }
}