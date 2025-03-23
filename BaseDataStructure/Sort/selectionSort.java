package Sort;

import static Sort.selectSort.swap;

public class selectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
