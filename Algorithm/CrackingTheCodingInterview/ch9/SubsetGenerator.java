package CrackingTheCodingInterview.ch9;

import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {
    // 递归方法生成子集
    public static List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    // 位运算方法生成子集
    public static List<List<Integer>> subsetsBitwise(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("递归方法生成的子集: " + subsetsRecursive(nums));
        System.out.println("位运算方法生成的子集: " + subsetsBitwise(nums));
    }
}    