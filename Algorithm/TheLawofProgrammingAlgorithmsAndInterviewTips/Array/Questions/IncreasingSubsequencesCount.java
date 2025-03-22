package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequencesCount {

    private static int count = 0;

    public static int findIncreasingSubsequencesCount(int[] nums) {
        List<Integer> current = new ArrayList<>();
        backtrack(nums, 0, current);
        return count;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current) {
        if (current.size() >= 2) {
            count++;
        }
        for (int i = start; i < nums.length; i++) {
            if (current.isEmpty() || nums[i] > current.get(current.size() - 1)) {
                current.add(nums[i]);
                backtrack(nums, i + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 9, 1, 7, 2, 6, 3, 8, 10, 4};
        int result = findIncreasingSubsequencesCount(a);
        System.out.println("递增子序列的个数为: " + result);
    }
}    