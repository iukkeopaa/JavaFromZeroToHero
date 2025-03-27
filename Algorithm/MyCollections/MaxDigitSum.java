package MyCollections;

//题目内容
//小红有一个正整数数字n，我们记,w(n)为n的数位之和，例如 w(123)= 6.
//毎次操作 → + 1或者ェ → -1，其操作过程需要保证n > 0。
//小红想知道在不超过k次操作的前提下，得到的数字m的u(m)最大是多少?
public class MaxDigitSum {

    // 计算一个数字的数位之和
    public static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // 找到在不超过 k 次操作下的最大数位和
    public static int findMaxDigitSum(int n, int k) {
        int maxSum = digitSum(n);
        // 尝试增加操作
        for (int i = 1; i <= k; i++) {
            if (n + i > 0) {
                maxSum = Math.max(maxSum, digitSum(n + i));
            }
        }
        // 尝试减少操作
        for (int i = 1; i <= k; i++) {
            if (n - i > 0) {
                maxSum = Math.max(maxSum, digitSum(n - i));
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int n = 123;
        int k = 5;
        int result = findMaxDigitSum(n, k);
        System.out.println("在不超过 " + k + " 次操作下，得到的数字的数位之和最大是: " + result);
    }
}    