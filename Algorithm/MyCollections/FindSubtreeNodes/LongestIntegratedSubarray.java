package MyCollections.FindSubtreeNodes;

import java.util.HashSet;
import java.util.Set;

//最长的可整合子数组的长度
//限定语言：C、Python、C++、Javascript、Python 3、Java、Go
//先给出可整合数组的定义：如果一个数组在排序之后，每相邻两个数的差的绝对值都为 1，
//或者该数组长度为 1，则该数组为可整合数组。例如，[5, 3, 4, 6, 2]排序后为[2, 3, 4, 5, 6]，
//符合每相邻两个数差的绝对值都为 1，所以这个数组为可整合数组
//给定一个数组 arr, 请返回其中最大可整合子数组的长度。例如，[5, 5, 3, 2, 6, 4, 3]的最大可
//整合子数组为[5, 3, 2, 6, 4]，所以请返回 5
//[要求]
//时间复杂度为 O(n^2)O(n2)，空间复杂度为 O(n)O(n)
public class LongestIntegratedSubarray {
    public static int getMaxLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set = new HashSet<>();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - i) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 3, 2, 6, 4, 3};
        System.out.println(getMaxLength(arr));
    }
}    