package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class FindTwoOddNumbers {
    public static int[] findOddOccurrences(int[] arr) {
        int x = 0;
        // 第一步：异或所有数，得到两个出现奇数次的数的异或结果
        for (int num : arr) {
            x ^= num;
        }

        // 找到 x 中为 1 的某一位，这里找最低位为 1 的位置
        int setBit = x & -x;

        int y = 0;
        // 第二步：只异或第 i 位为 1 的那些数
        for (int num : arr) {
            if ((num & setBit) != 0) {
                y ^= num;
            }
        }

        return new int[]{y, x ^ y};
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 3, 2, 5, 4, 6};
        int[] result = findOddOccurrences(arr);
        System.out.println("出现奇数次的两个数是: " + result[0] + " 和 " + result[1]);
    }
}    