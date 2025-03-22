package MyCollections.FindSubtreeNodes;

//在一个数组中，时间复杂度 O(n)找出左边比右边大的最大值，比如 a[] = {1,3,7,5,2,9,8}，左
//边选出 7，右边选 2，他们差值最大，为 5。（算法题没做出来，应该是最致命的吧）
public class FindMaxDifference {
    public static int findMaxDifference(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int maxDiff = 0;
        int maxLeft = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < maxLeft) {
                maxDiff = Math.max(maxDiff, maxLeft - arr[i]);
            } else {
                maxLeft = arr[i];
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 5, 2, 9, 8};
        int result = findMaxDifference(arr);
        System.out.println("最大差值是: " + result);
    }
}    