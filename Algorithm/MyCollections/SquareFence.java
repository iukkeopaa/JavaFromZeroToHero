package MyCollections;

import java.util.Arrays;

//假设你是一位园艺设计师，你手头有一些木板，每块木板的长度不同。你需要用这些木板来建造一个正方形的花坛围
//栏。你不能切割任何一块木板，但你可以把它们连在一起，而且每块木板必须使用一次。如果你能用这些木板拼成一个
//正方形的围栏，则返回 true ;否则返回 false。
public class SquareFence {
    public static boolean canFormSquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int sideLength = sum / 4;
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, 0, 0, sideLength, 0);
    }

    private static boolean backtrack(int[] nums, boolean[] used, int currentSide, int index, int sideLength, int sidesDone) {
        if (sidesDone == 3) {
            return true;
        }
        if (currentSide == sideLength) {
            return backtrack(nums, used, 0, 0, sideLength, sidesDone + 1);
        }
        for (int i = index; i < nums.length; i++) {
            if (!used[i] && currentSide + nums[i] <= sideLength) {
                used[i] = true;
                if (backtrack(nums, used, currentSide + nums[i], i + 1, sideLength, sidesDone)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] boards = {1, 1, 2, 2, 2};
        System.out.println(canFormSquare(boards));
    }
}