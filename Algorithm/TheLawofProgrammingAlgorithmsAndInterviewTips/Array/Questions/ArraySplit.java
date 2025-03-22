package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.Arrays;

public class ArraySplit {
    public static int maxSplit(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int m = nums.length; m > 0; m--) {
            if (sum % m == 0) {
                int target = sum / m;
                boolean[] used = new boolean[nums.length];
                if (canSplit(nums, used, 0, m, 0, target)) {
                    return m;
                }
            }
        }
        return 1;
    }

    private static boolean canSplit(int[] nums, boolean[] used, int start, int m, int currentSum, int target) {
        if (m == 0) {
            return true;
        }
        if (currentSum == target) {
            return canSplit(nums, used, 0, m - 1, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (!used[i] && currentSum + nums[i] <= target) {
                used[i] = true;
                if (canSplit(nums, used, i + 1, m, currentSum + nums[i], target)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 3, 6};
        System.out.println("m 的最大值为: " + maxSplit(nums));
    }
}    