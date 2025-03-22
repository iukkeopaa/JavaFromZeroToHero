package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.ArrayList;
import java.util.List;

public class ArrayEqualSumAllocation {

    public static List<List<Integer>> findEqualSumPartition(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return result;
        }
        int target = totalSum / 2;
        boolean[] used = new boolean[n];
        backtrack(nums, 0, 0, target, used, result);
        return result;
    }

    private static void backtrack(int[] nums, int start, int currentSum, int target, boolean[] used, List<List<Integer>> result) {
        if (currentSum == target) {
            List<Integer> partition1 = new ArrayList<>();
            List<Integer> partition2 = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    partition1.add(nums[i]);
                } else {
                    partition2.add(nums[i]);
                }
            }
            result.add(partition1);
            result.add(partition2);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (currentSum + nums[i] <= target) {
                used[i] = true;
                backtrack(nums, i + 1, currentSum + nums[i], target, used, result);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> partitions = findEqualSumPartition(nums);
        if (partitions.isEmpty()) {
            System.out.println("未找到符合条件的分配。");
        } else {
            for (int i = 0; i < partitions.size(); i += 2) {
                System.out.println("分区 1: " + partitions.get(i));
                System.out.println("分区 2: " + partitions.get(i + 1));
            }
        }
    }
}    