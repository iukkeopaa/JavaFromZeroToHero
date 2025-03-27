package MyCollections;

//小美拿到了一个大小为n的数组，她希望删除一个区间后，使得剩余所有元素的乘积未尾至少有た个0。小美想知
//道，一共有多少种不同的删除方案?
public class ArrayDeletionScheme {
    public static int countWays(int[] arr, int k) {
        int n = arr.length;
        // 前缀和数组，用于存储 2 和 5 的因子数量
        int[][] prefixSum = new int[n + 1][2];

        // 计算前缀和
        for (int i = 1; i <= n; i++) {
            int num = arr[i - 1];
            int twoCount = 0, fiveCount = 0;
            // 统计因数 2 的个数
            while (num % 2 == 0) {
                twoCount++;
                num /= 2;
            }
            // 统计因数 5 的个数
            while (num % 5 == 0) {
                fiveCount++;
                num /= 5;
            }
            // 更新前缀和数组
            prefixSum[i][0] = prefixSum[i - 1][0] + twoCount;
            prefixSum[i][1] = prefixSum[i - 1][1] + fiveCount;
        }

        int ways = 0;
        // 枚举所有可能的删除区间
        for (int l = 0; l <= n; l++) {
            for (int r = l; r <= n; r++) {
                // 计算剩余元素中因数 2 的总数
                int totalTwo = prefixSum[n][0] - (prefixSum[r][0] - prefixSum[l][0]);
                // 计算剩余元素中因数 5 的总数
                int totalFive = prefixSum[n][1] - (prefixSum[r][1] - prefixSum[l][1]);
                // 检查剩余元素乘积末尾 0 的数量是否满足条件
                if (Math.min(totalTwo, totalFive) >= k) {
                    ways++;
                }
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 10, 20};
        int k = 2;
        System.out.println(countWays(arr, k));
    }
}    