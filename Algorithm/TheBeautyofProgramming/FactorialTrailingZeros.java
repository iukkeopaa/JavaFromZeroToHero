package TheBeautyofProgramming;

public class FactorialTrailingZeros {
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 10;
        int result = trailingZeroes(N);
        System.out.println("N = " + N + ", N! 的末尾 0 的个数为: " + result);
    }
}    