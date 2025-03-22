package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class MinAbsoluteValue {
    public static int findMinAbsoluteValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        int minAbs = Math.abs(arr[0]);
        for (int num : arr) {
            int currentAbs = Math.abs(num);
            if (currentAbs < minAbs) {
                minAbs = currentAbs;
            }
        }
        return minAbs;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -2, 1, 3, 5};
        int minAbs = findMinAbsoluteValue(arr);
        System.out.println("数组中元素的最小绝对值是: " + minAbs);
    }
}    