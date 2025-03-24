package MyCollections.FindSubtreeNodes;

//一个升序数组，找出其中绝对值最小的数
public class FindMinAbsoluteValue {
    public static int findMinAbs(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        int minAbs = Math.abs(arr[0]);
        int result = arr[0];
        for (int num : arr) {
            int abs = Math.abs(num);
            if (abs < minAbs) {
                minAbs = abs;
                result = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -2, -1, 0, 1, 2, 3};
        int minAbsValue = findMinAbs(arr);
        System.out.println("绝对值最小的数是: " + minAbsValue);
    }
}    