package TheLawofProgrammingAlgorithmsAndInterviewTips.Array;

import java.util.ArrayList;
import java.util.List;

public class ArraySplit {

    public static void splitArray(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        int minDiff = Integer.MAX_VALUE;
        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();

        // 遍历所有可能的组合
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum1 = 0;
            List<Integer> currentGroup1 = new ArrayList<>();
            List<Integer> currentGroup2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum1 += arr[i];
                    currentGroup1.add(arr[i]);
                } else {
                    currentGroup2.add(arr[i]);
                }
            }
            int sum2 = totalSum - sum1;
            int diff = Math.abs(sum1 - sum2);
            if (diff < minDiff) {
                minDiff = diff;
                group1 = new ArrayList<>(currentGroup1);
                group2 = new ArrayList<>(currentGroup2);
            }
        }

        System.out.println("第一组: " + group1);
        System.out.println("第二组: " + group2);
        System.out.println("两组和的差的绝对值: " + minDiff);
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 5, 6, 7};
        splitArray(arr1);

        int[] arr2 = {2, 5, 6, 10};
        splitArray(arr2);
    }
}    