package MyCollections;

import java.util.Scanner;

//题目内容
//小苯定义一个排列的权值为:
//如果排列不满足严格上升，则权值为0。
//否则，严格上升的排列其权值为:排列的长度。
//现在小苯有个长为n的a数组，他想知道a中所有"排列“子序列(即:此子序列是一个排列)的权值之和，请你帮他算-
//算吧。
//输入描述
//每个测试文件内都包含多组测试数据。
//第一行一个正整数 T(1 < T < 100)，表示测试数据的组数
//接下来对于每组测试数据，输入包含两行。
//第一行一个正整数n(1 ≤n ≤ 2x 10”)，表示数组a的长度。
//第二行n个整数a?(1 ≤ ai≤ n)，表示数组a。
//(保证所有测试数据中n的总和不超过3x 10%。)
public class PermutationSubsequenceWeightDP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 测试数据的组数

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt(); // 数组 a 的长度
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(calculateWeightSum(a));
        }
        scanner.close();
    }

    private static int calculateWeightSum(int[] a) {
        int n = a.length;
        int[] dp = new int[n + 1];
        int maxVal = 0;
        for (int num : a) {
            maxVal = Math.max(maxVal, num);
        }

        int result = 0;
        for (int num : a) {
            if (num == 1) {
                dp[1] = 1;
            } else if (dp[num - 1] > 0) {
                dp[num] += dp[num - 1];
            }
            if (isValidPermutationEndingAt(dp, num)) {
                result += num;
            }
        }

        return result;
    }

    private static boolean isValidPermutationEndingAt(int[] dp, int x) {
        for (int i = 1; i <= x; i++) {
            if (dp[i] == 0) {
                return false;
            }
        }
        return true;
    }
}    