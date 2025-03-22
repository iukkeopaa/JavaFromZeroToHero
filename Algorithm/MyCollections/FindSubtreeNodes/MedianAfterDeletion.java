package MyCollections.FindSubtreeNodes;

import java.util.Arrays;

//n(偶数)的整数数组，需要输出删除其中任意一个数后数组的中位数；
public class MedianAfterDeletion {
    public static double[] findMediansAfterDeletion(int[] nums) {
        int n = nums.length;
        double[] medians = new double[n];

        for (int i = 0; i < n; i++) {
            int[] newNums = new int[n - 1];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    newNums[index++] = nums[j];
                }
            }
            Arrays.sort(newNums);
            int mid = (n - 1) / 2;
            if ((n - 1) % 2 == 1) {
                medians[i] = (double) (newNums[mid] + newNums[mid + 1]) / 2;
            } else {
                medians[i] = newNums[mid];
            }
        }
        return medians;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        double[] medians = findMediansAfterDeletion(nums);
        for (double median : medians) {
            System.out.println(median);
        }
    }
}    