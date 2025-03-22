package CrackingTheCodingInterview.ch5;

public class MissingNumber {
    public static int findMissingNumber(int[] A) {
        int n = A.length;
        int missing = 0;
        for (int bit = 0; bit < 32; bit++) {
            int expectedCount = 0;
            int actualCount = 0;
            // 计算完整序列中该位为 1 的数量
            for (int i = 0; i <= n; i++) {
                expectedCount += (i >> bit) & 1;
            }
            // 计算数组中该位为 1 的数量
            for (int num : A) {
                actualCount += (num >> bit) & 1;
            }
            // 如果数量不同，说明缺失的数在该位为 1
            if (expectedCount != actualCount) {
                missing |= (1 << bit);
            }
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 4, 5};
        int missing = findMissingNumber(A);
        System.out.println("缺失的整数是: " + missing);
    }
}