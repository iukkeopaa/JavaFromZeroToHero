package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class FindTwoDifferentNumbers {
    public static int[] findTwoDifferent(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int diffBit = xor & (-xor);

        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & diffBit) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = findTwoDifferent(nums);
        System.out.println("两个不同的元素是: " + result[0] + " 和 " + result[1]);
    }
}    