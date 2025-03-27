package MyCollections;

import java.util.Arrays;

//小明是一位资深的程序员,他最近在研究一种特殊的数组操作。他有一个由正整数组成的数组,数组的长度是偶数。小明可
//以对数组中的任意一个数字执行以下两种操作之一
//1.将该数字乘以 2;
//2.将该数字除以 2 并向下取整。
//小明的目标是通过一系列操作,使得最终数组中恰好一半的数字是奇数,另一半是偶数。他希望找到一种方案,使得操作次
//数最少
public class ArrayOddEvenOperation {

    // 计算将一个偶数变为奇数所需的最少操作次数
    private static int countToOdd(int num) {
        int operations = 0;
        while (num % 2 == 0) {
            num /= 2;
            operations++;
        }
        return operations;
    }

    // 计算将一个奇数变为偶数所需的最少操作次数
    private static int countToEven(int num) {
        if (num % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int oddCount = 0;
        int[] evenToOdd = new int[n];
        int[] oddToEven = new int[n];

        // 统计奇数数量，并分别计算每个偶数变奇数、奇数变偶数所需的操作次数
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                oddCount++;
                oddToEven[i] = countToEven(nums[i]);
            } else {
                evenToOdd[i] = countToOdd(nums[i]);
            }
        }

        int targetOdd = n / 2;
        if (oddCount == targetOdd) {
            return 0;
        } else if (oddCount > targetOdd) {
            // 奇数过多，把一些奇数变为偶数
            Arrays.sort(oddToEven);
            int diff = oddCount - targetOdd;
            int operations = 0;
            for (int i = 0; i < diff; i++) {
                operations += oddToEven[i];
            }
            return operations;
        } else {
            // 偶数过多，把一些偶数变为奇数
            Arrays.sort(evenToOdd);
            int diff = targetOdd - oddCount;
            int operations = 0;
            for (int i = 0; i < diff; i++) {
                operations += evenToOdd[i];
            }
            return operations;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 1};
        System.out.println("最少操作次数: " + minOperations(nums));
    }
}    