package MyCollections.FindSubtreeNodes.RandomSelectMFromN;

import java.util.Arrays;
import java.util.Random;

public class RandomSelectMFromN {
    public static int[] selectRandom(int[] nums, int m) {
        int n = nums.length;
        if (n <= m) {
            return nums;
        }
        int[] result = new int[m];
        // 前 m 个元素直接放入结果数组
        System.arraycopy(nums, 0, result, 0, m);
        Random random = new Random();
        for (int i = m; i < n; i++) {
            // 生成 0 到 i 之间的随机数
            int j = random.nextInt(i + 1);
            if (j < m) {
                // 如果随机数小于 m，替换结果数组中的元素
                result[j] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int m = 3;
        int[] selected = selectRandom(nums, m);
        System.out.println(Arrays.toString(selected));
    }
}    