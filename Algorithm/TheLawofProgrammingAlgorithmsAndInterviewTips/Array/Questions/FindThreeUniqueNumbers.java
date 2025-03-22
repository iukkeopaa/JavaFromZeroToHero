package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.ArrayList;
import java.util.List;

public class FindThreeUniqueNumbers {
    public static int[] findThreeUniqueNumbers(int[] nums) {
        int xorAll = 0;
        for (int num : nums) {
            xorAll ^= num;
        }

        int flag = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & bit) != 0) {
                    count++;
                }
            }
            if (count % 2 == 1) {
                flag = bit;
                break;
            }
        }

        int num1 = 0;
        for (int num : nums) {
            if ((num & flag) != 0) {
                num1 ^= num;
            }
        }

        List<Integer> remaining = new ArrayList<>();
        for (int num : nums) {
            if (num != num1) {
                remaining.add(num);
            }
        }

        int[] remainingNums = new int[remaining.size()];
        for (int i = 0; i < remaining.size(); i++) {
            remainingNums[i] = remaining.get(i);
        }

        int xorRemaining = 0;
        for (int num : remainingNums) {
            xorRemaining ^= num;
        }

        flag = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;
            if ((xorRemaining & bit) != 0) {
                flag = bit;
                break;
            }
        }

        int num2 = 0;
        int num3 = 0;
        for (int num : remainingNums) {
            if ((num & flag) != 0) {
                num2 ^= num;
            } else {
                num3 ^= num;
            }
        }

        return new int[]{num1, num2, num3};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 2, 3, 4, 6, 7, 6};
        int[] result = findThreeUniqueNumbers(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}    