package MyCollections;

import java.util.Scanner;

//题目内容
//小红希望你构造一个长度为n的数组,满足:
//1.数组中的每个元素a满足0 < a;< 2'
//2.数组所有元素的异或和小于等于所有元素的与和。即
//a $ a2 ...ansa,&a?&...&an
//小红想知道有多少种可能的方案数。
//输入描述
//第一行输入两个整数n和k。
//1 ≤n≤ 10'
//0≤k≤ 10'
//输出描述
//输出一个整数，表示满足条件的数组的方案数。由于答案可能很大，请对10°+ 7取模。
public class ArrayConstruction1 {
    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int limit = 1 << k;

        // dp[i][j][l] 表示已经构造了 i 个元素，异或和为 j，与和为 l 的方案数
        long[][][] dp = new long[n + 1][limit][limit];
        dp[0][0][limit - 1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < limit; j++) {
                for (int l = 0; l < limit; l++) {
                    if (dp[i][j][l] == 0) continue;
                    for (int num = 1; num < limit; num++) {
                        int newXor = j ^ num;
                        int newAnd = l & num;
                        dp[i + 1][newXor][newAnd] = (dp[i + 1][newXor][newAnd] + dp[i][j][l]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (int j = 0; j < limit; j++) {
            for (int l = 0; l < limit; l++) {
                if (j <= l) {
                    ans = (ans + dp[n][j][l]) % MOD;
                }
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}    