package DaChangBrushUpClass.class1.class2.class1.Class2;


//给定一个数组arr，只能对arr中的一个子数组排序，但是想让arr整体都有序，返回满足这一设定的子数组中最短的是多长
//例如：arr = [1,5,3,4,2,6,7]，返回4，因为只有[5,3,4,2]需要排序，对其排序，整个数组都有序。
//[要求]时间复杂度为O(n)，空间复杂度为O(1)。

//思路
//

public class ShortestSortedSubarray {
    public static int findUnsortedSubarray(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int right = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < max) {
                right = i;
            } else {
                max = arr[i];
            }
        }

        int min = Integer.MAX_VALUE;
        int left = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > min) {
                left = i;
            } else {
                min = arr[i];
            }
        }

        if (left == -1 && right == -1) {
            return 0;
        }

        return right - left + 1;
    }


    public static int findUnsortedSubarray1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int N = nums.length;
        int right = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (max > nums[i]) {
                right = i;
            }
            max = Math.max(max, nums[i]);
        }
        int min = Integer.MAX_VALUE;
        int left = N;
        for (int i = N - 1; i >= 0; i--) {
            if (min < nums[i]) {
                left = i;
            }
            min = Math.min(min, nums[i]);
        }
        return Math.max(0, right - left + 1);
    }
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println("最短子数组的长度为: " + findUnsortedSubarray(arr));
    }
}    