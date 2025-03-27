package Array.Q53;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // 定义状态数组
        int[] dp = new int[n];
        // 初始化 dp[0]
        dp[0] = nums[0];
        // 记录最大和
        int maxSum = dp[0];

        // 遍历数组
        for (int i = 1; i < n; i++) {
            // 状态转移方程
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 更新最大和
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }


    //

    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
    public static int maxSubArray4(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int minPreSum = 0;
        int preSum = 0;
        for (int x : nums) {
            preSum += x; // 当前的前缀和
            ans = Math.max(ans, preSum - minPreSum); // 减去前缀和的最小值
            minPreSum = Math.min(minPreSum, preSum); // 维护前缀和的最小值
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("最大和的连续子数组的和为: " + solution.maxSubArray(nums));
    }
}    