package CrackingTheCodingInterview.ch5;

public class InsertMIntoN {
    public static int updateBits(int n, int m, int i, int j) {
        // 创建一个掩码，用于清除 N 中从第 i 位到第 j 位的所有位
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = ((1 << i) - 1);
        int mask = left | right;
        // 清除 N 中从第 i 位到第 j 位的所有位
        int n_cleared = n & mask;
        // 将 M 左移 i 位，使其对齐到 N 的第 i 位
        int m_shifted = m << i;
        // 将 M 插入到 N 中
        return n_cleared | m_shifted;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt("10000000000", 2);
        int M = Integer.parseInt("10011", 2);
        int i = 2;
        int j = 6;
        int result = updateBits(N, M, i, j);
        System.out.println("N = " + Integer.toBinaryString(result));
    }
}    