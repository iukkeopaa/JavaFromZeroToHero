package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.Arrays;

public class FindTwoNumbers {
    public static int[] findClosestToZero(int[] arr) {
        if (arr.length < 2) {
            return null;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int minSum = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                num1 = arr[left];
                num2 = arr[right];
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] arr = {1, 60, -10, 70, -80, 85};
        int[] result = findClosestToZero(arr);
        System.out.println("和最接近 0 的两个数是: " + result[0] + " 和 " + result[1]);
    }
}    