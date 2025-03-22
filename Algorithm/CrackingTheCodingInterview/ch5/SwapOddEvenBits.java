package CrackingTheCodingInterview.ch5;

public class SwapOddEvenBits {
    public static int swapBits(int x) {
        // 提取奇数位，右移一位
        int oddBits = (x & 0x55555555) << 1;
        // 提取偶数位，左移一位
        int evenBits = (x & 0xAAAAAAAA) >> 1;
        // 合并奇数位和偶数位
        return oddBits | evenBits;
    }

    public static void main(String[] args) {
        int num = 23;
        int result = swapBits(num);
        System.out.println("原始数字: " + num);
        System.out.println("交换后的数字: " + result);
    }
}    