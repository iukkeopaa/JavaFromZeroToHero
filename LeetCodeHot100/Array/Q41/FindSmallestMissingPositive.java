package Array.Q41;



//思路1 哈希表 ，空间复杂度不符合
//思路2 二分查找 时间复杂度不符合
//思路3 原地哈希 哈希函数就是 i-1
public class FindSmallestMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 第一步：将所有小于等于 0 或者大于 n 的数置为 n + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // 第二步：利用数组下标标记出现过的正整数
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // 第三步：找到第一个正数所在的索引
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // 如果数组中所有元素都是负数，返回 n + 1
        return n + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }







    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("未出现的最小正整数是: " + firstMissingPositive(nums));
    }
}    