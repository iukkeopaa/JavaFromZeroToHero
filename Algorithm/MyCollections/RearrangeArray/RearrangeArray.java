package MyCollections.FindSubtreeNodes.RearrangeArray;

import java.util.Arrays;

public class RearrangeArray {
    public static void rearrange(int[] arr) {
        int n = arr.length;
        int positiveIndex = 0;
        int negativeIndex = 1;
        while (true) {
            while (positiveIndex < n && arr[positiveIndex] > 0) {
                positiveIndex += 2;
            }
            while (negativeIndex < n && arr[negativeIndex] < 0) {
                negativeIndex += 2;
            }
            if (positiveIndex < n && negativeIndex < n) {
                int temp = arr[positiveIndex];
                arr[positiveIndex] = arr[negativeIndex];
                arr[negativeIndex] = temp;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, -3, 4, -5, 6};
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }
}    