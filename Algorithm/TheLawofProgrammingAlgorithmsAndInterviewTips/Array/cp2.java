package TheLawofProgrammingAlgorithmsAndInterviewTips.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cp2 {
    public static int[] findPair(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{complement, nums[i]};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 7, 11, 15};
        int target = 15;
        int[] pair = findPair(nums, target);
        if (pair.length == 2) {
            System.out.println(pair[0] + " 和 " + pair[1]);
        } else {
            System.out.println("未找到符合条件的数对");
        }
    }
}



 class FindTwoSumIndices {
    public static List<int[]> findTwoSum(int[] a, int n) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == n) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15, 3, 6};
        int n = 9;
        List<int[]> indices = findTwoSum(a, n);
        for (int[] indexPair : indices) {
            System.out.println("Indices: [" + indexPair[0] + ", " + indexPair[1] + "]");
        }
    }
}