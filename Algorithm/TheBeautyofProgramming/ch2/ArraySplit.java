package TheBeautyofProgramming.ch2;

import java.util.ArrayList;
import java.util.List;

public class ArraySplit {
    private static int minDiff = Integer.MAX_VALUE;
    private static List<Integer> resultSubset1 = new ArrayList<>();
    private static List<Integer> resultSubset2 = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length / 2;
        List<Integer> subset1 = new ArrayList<>();
        List<Integer> subset2 = new ArrayList<>();
        splitArray(arr, 0, subset1, subset2);
        System.out.println("Subset 1: " + resultSubset1);
        System.out.println("Subset 2: " + resultSubset2);
        System.out.println("Minimum difference: " + minDiff);
    }

    private static void splitArray(int[] arr, int index, List<Integer> subset1, List<Integer> subset2) {
        if (index == arr.length) {
            if (subset1.size() == subset2.size()) {
                int sum1 = 0;
                int sum2 = 0;
                for (int num : subset1) {
                    sum1 += num;
                }
                for (int num : subset2) {
                    sum2 += num;
                }
                int diff = Math.abs(sum1 - sum2);
                if (diff < minDiff) {
                    minDiff = diff;
                    resultSubset1 = new ArrayList<>(subset1);
                    resultSubset2 = new ArrayList<>(subset2);
                }
            }
            return;
        }
        subset1.add(arr[index]);
        splitArray(arr, index + 1, subset1, subset2);
        subset1.remove(subset1.size() - 1);

        subset2.add(arr[index]);
        splitArray(arr, index + 1, subset1, subset2);
        subset2.remove(subset2.size() - 1);
    }
}    