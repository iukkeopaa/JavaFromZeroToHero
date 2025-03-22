package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.Arrays;

public class ArrangeArrayToMinNumber {
    public static String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {32, 321};
        System.out.println(minNumber(nums));
    }
}    