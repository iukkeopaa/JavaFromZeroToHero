package DaChangBrushUpClass.class1.class2.class1.Class3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//给定整数数组nums和目标值goal，需要从nums中选出一个子序列，使子序列元素总和最接近goal
//也就是说如果子序列元素和为sum ，需要最小化绝对差abs(sum - goal)，返回 abs(sum - goal)可能的最小值
//注意数组的子序列是通过移除原始数组中的某些元素（可能全部或无）而形成的数组。


//思路

//将数组分成左右两部分，分别计算左右两部分的所有子序列和，然后将左半部分的子序列和和右半部分的子序列和进行排序
//对于左半部分的每个子序列和，在右半部分的子序列和中找到最接近goal - leftSum的子序列和
//计算abs(leftSum + rightSum - goal)，并更新最小差值
//最后返回最小差值


//例子
//nums = [1, 2, 3, 4, 5], goal = 6
//将数组分成左右两部分，左半部分为[1, 2]，右半部分为[3, 4, 5]
//计算左半部分的所有子序列和[0, 1, 2, 3]，右半部分的所有子序列和[0, 3, 4, 5, 8]
//对于左半部分的每个子序列和，在右半部分的子序列和中找到最接近goal - leftSum的子序列和
//对于左半部分的子序列和0，在右半部分的子序列和中找到最接近6 - 0 = 6的子序列和0，计算abs(0 + 0 - 6) = 6
//对于左半部分的子序列和1，在右半部分的子序列和中找到最接近6 - 1 = 5的子序列和3，计算abs(1 + 3 - 6) = 2
//对于左半部分的子序列和2，在右半部分的子序列和中找到最接近6 - 2 = 4的子序列和4，计算abs(2 + 4 - 6) = 2
//对于左半部分的子序列和3，在右半部分的子序列和中找到最接近6 - 3 = 3的子序列和3，计算abs(3 + 3 - 6) = 3
//返回最小差值2
public class ClosestSubsequenceSum {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int left = n / 2;
        int right = n - left;

        // 生成左半部分的所有子序列和
        List<Integer> leftSums = generateSums(nums, 0, left);
        // 生成右半部分的所有子序列和
        List<Integer> rightSums = generateSums(nums, left, right);

        // 对右半部分的子序列和进行排序
        Collections.sort(rightSums);

        int minDiff = Integer.MAX_VALUE;
        // 遍历左半部分的子序列和
        for (int leftSum : leftSums) {
            int target = goal - leftSum;
            // 二分查找右半部分中最接近 target 的值
            int index = Collections.binarySearch(rightSums, target);
            if (index < 0) {
                index = -(index + 1);
            }
            // 检查最接近的两个值
            if (index < rightSums.size()) {
                minDiff = Math.min(minDiff, Math.abs(leftSum + rightSums.get(index) - goal));
            }
            if (index > 0) {
                minDiff = Math.min(minDiff, Math.abs(leftSum + rightSums.get(index - 1) - goal));
            }
        }

        return minDiff;
    }

    // 生成数组中指定范围的所有子序列和
    private List<Integer> generateSums(int[] nums, int start, int length) {
        List<Integer> sums = new ArrayList<>();
        int end = start + length;
        // 遍历所有可能的组合
        for (int mask = 0; mask < (1 << length); mask++) {
            int sum = 0;
            for (int i = 0; i < length; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[start + i];
                }
            }
            sums.add(sum);
        }
        return sums;
    }

    public static void main(String[] args) {
        ClosestSubsequenceSum solution = new ClosestSubsequenceSum();
        int[] nums = {1, 2, 3};
        int goal = 6;
        System.out.println(solution.minAbsDifference(nums, goal));
    }
}    