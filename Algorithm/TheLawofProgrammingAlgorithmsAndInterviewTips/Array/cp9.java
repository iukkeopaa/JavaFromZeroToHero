package TheLawofProgrammingAlgorithmsAndInterviewTips.Array;

import java.util.Arrays;

public class cp9 {

    // 交换数组中从 start 到 end 的元素
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // 循环移位 k 个位置
    private static void cyclicShift(int[] arr, int start, int end, int k) {
        reverse(arr, start, start + k - 1);
        reverse(arr, start + k, end);
        reverse(arr, start, end);
    }

    // 重排数组
    private static void rearrange(int[] arr, int start, int end) {
        int n = (end - start + 1) / 2;
        if (n <= 1) {
            return;
        }
        int mid = start + n;
        int leftMid = start + n / 2;
        int rightMid = mid + n / 2;

        // 交换数组中间部分
        cyclicShift(arr, leftMid, rightMid - 1, n / 2);

        // 递归处理左右两部分
        rearrange(arr, start, start + n - 1);
        rearrange(arr, start + n, end);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rearrange(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}


 class TripleHandShuffle {
    public static void tripleShuffle(int[] arr) {
        int n = arr.length / 3;
        int[] result = new int[arr.length];
        for (int i = 0; i < n; i++) {
            result[3 * i] = arr[2 * n + i];
            result[3 * i + 1] = arr[n + i];
            result[3 * i + 2] = arr[i];
        }
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int n = 3;
        int[] arr = new int[3 * n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
            arr[n + i] = i + n + 1;
            arr[2 * n + i] = i + 2 * n + 1;
        }
        System.out.println("原始数组: " + Arrays.toString(arr));
        tripleShuffle(arr);
        System.out.println("洗牌后的数组: " + Arrays.toString(arr));
    }
}