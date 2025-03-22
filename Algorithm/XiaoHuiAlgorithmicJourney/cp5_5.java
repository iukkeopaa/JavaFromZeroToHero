package XiaoHuiAlgorithmicJourney;

public class cp5_5 {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int num1 = 16;
        int num2 = 15;
        System.out.println(num1 + " 是否为2的整数次幂: " + isPowerOfTwo(num1));
        System.out.println(num2 + " 是否为2的整数次幂: " + isPowerOfTwo(num2));
    }
}