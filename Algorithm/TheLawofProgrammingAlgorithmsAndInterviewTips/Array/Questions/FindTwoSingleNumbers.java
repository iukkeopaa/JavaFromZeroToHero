package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class FindTwoSingleNumbers {
    public static int[] findTwoSingleNumbers(int[] nums) {
        int xorResult = 0;
        // 对数组中所有数字进行异或操作
        for (int num : nums) {
            xorResult ^= num;
        }

        // 找到异或结果中第一个为 1 的位
        int diff = 1;
        while ((xorResult & diff) == 0) {
            diff <<= 1;
        }

        int num1 = 0, num2 = 0;
        // 根据不同的位将数组分为两组，分别进行异或操作
        for (int num : nums) {
            if ((num & diff) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = findTwoSingleNumbers(nums);
        System.out.println("两个只出现一次的数字是: " + result[0] + " 和 " + result[1]);
    }
}    