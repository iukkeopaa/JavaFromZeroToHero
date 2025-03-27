package MyCollections;

import java.util.Arrays;

//题目描述
//这里有几个正整数，a1,…, an，Alice 会先去掉其中最多 d个数
//Bob 接下来会将剩余的数中最多m个数乘以 -k
//Alice 想要剩余数之和尽可能大，Bob 想要剩余数之和尽可能小。
//假设 Aice 和 Bob 都足够聪明，请问最后剩余数之和是多少,
public class NumberGameSum {

    public static int calculateSum(int[] numbers, int d, int m, int k) {
        int n = numbers.length;
        int maxSum = Integer.MIN_VALUE;

        // 枚举 Alice 移除 d 个数的所有可能情况
        // 用位运算来枚举所有移除组合
        for (int aliceMask = 0; aliceMask < (1 << n); aliceMask++) {
            int removedCount = Integer.bitCount(aliceMask);
            if (removedCount > d) continue;

            int[] remaining = new int[n - removedCount];
            int index = 0;
            for (int i = 0; i < n; i++) {
                if ((aliceMask & (1 << i)) == 0) {
                    remaining[index++] = numbers[i];
                }
            }

            // 对剩余的数进行排序
            Arrays.sort(remaining);

            // 枚举 Bob 选择 m 个数乘以 -k 的所有可能情况
            int remainingLength = remaining.length;
            for (int bobMask = 0; bobMask < (1 << remainingLength); bobMask++) {
                int multipliedCount = Integer.bitCount(bobMask);
                if (multipliedCount > m) continue;

                int currentSum = 0;
                for (int i = 0; i < remainingLength; i++) {
                    if ((bobMask & (1 << i)) != 0) {
                        currentSum += remaining[i] * (-k);
                    } else {
                        currentSum += remaining[i];
                    }
                }

                // 更新最大和
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int d = 1;
        int m = 2;
        int k = 2;
        int result = calculateSum(numbers, d, m, k);
        System.out.println("最后剩余数之和是: " + result);
    }
}    