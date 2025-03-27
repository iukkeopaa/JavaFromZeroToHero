package MyCollections;

import java.util.Scanner;

//题目内容
//对于给定的正偶数n和正整数m，求解下式:
//cor号mod n
//这显然难不倒你，所以，我们将会使用一种特殊的方式给出n的二进制形式:给出一个由个整数构成的数组(
//41,“2,…, “)，其中，第i个整数a;代表n的二进制表示中，从高位到低位，恰好有连续i个imod 2。更具体地，如果
//数组a={3,4,1,2}，那么，第一个整数a,就代表有3 个3 mod 2=1,第二个整数a,就代表有4 个4 mod2=0,…
//最终，可以得到n的二进制表示为1110000100。
//输入描述
//第-行输入两个整数k,m(1 ≦た≤2x10';1≤m≤ 10°)。
//第二行输入た个正整数a1,a2,…, a(1 ≦ a?≤ 10°)。
//除此之外，保证单个测试文件的q;之和不超过10”。
public class BinaryCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[k];
        int[] prefixSum = new int[k + 1];

        // 计算前缀和
        for (int i = 0; i < k; i++) {
            a[i] = scanner.nextInt();
            prefixSum[i + 1] = prefixSum[i] + a[i];
        }

        long result = 0;
        long mod = (long) (2 * Math.PI);

        // 处理每个交界处
        for (int i = 0; i < k - 1; i++) {
            int position = prefixSum[i + 1];
            result = (result + fastPower(2, position, mod)) % mod;
        }

        result = (long) (Math.cos(result) % m);
        System.out.println(result);
        scanner.close();
    }

    // 快速幂算法
    public static long fastPower(long base, long exponent, long mod) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result;
    }
}    