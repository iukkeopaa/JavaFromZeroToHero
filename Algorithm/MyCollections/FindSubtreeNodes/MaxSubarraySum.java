package MyCollections.FindSubtreeNodes;

//子数组的最大累加和问题
public class MaxSubarraySum {
    public static int maxSubArray(int[] nums) {
        // 当前子数组的最大和
        int currentMax = nums[0];
        // 全局最大和
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 更新当前子数组的最大和
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // 更新全局最大和
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println("子数组的最大累加和是: " + result);
    }
}    