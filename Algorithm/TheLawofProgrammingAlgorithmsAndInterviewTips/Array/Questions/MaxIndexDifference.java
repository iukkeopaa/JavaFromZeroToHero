package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class MaxIndexDifference {
    public static int maxIndexDiff(int[] arr) {
        int n = arr.length;
        int maxDiff = 0;
        // 从左到右记录最小值的下标
        int[] leftMin = new int[n];
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        }
        // 从右到左记录最大值的下标
        int[] rightMax = new int[n];
        rightMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], arr[j]);
        }
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (leftMin[i] < rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int result = maxIndexDiff(arr);
        System.out.println("最大下标差值为: " + result);
    }
}    