package MyCollections.FindSubtreeNodes;

//给出一个数组，找出左边减去右边的最大值(不是绝对值)，要求时间复杂度 O(n)
public class MaxDifference {
    public static int findMaxDifference(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int maxDiff = Integer.MIN_VALUE;
        int maxLeft = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int diff = maxLeft - arr[i];
            if (diff > maxDiff) {
                maxDiff = diff;
            }
            if (arr[i] > maxLeft) {
                maxLeft = arr[i];
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 5, 6, 3, 2};
        int result = findMaxDifference(arr);
        System.out.println("左边减去右边的最大值是: " + result);
    }
}    