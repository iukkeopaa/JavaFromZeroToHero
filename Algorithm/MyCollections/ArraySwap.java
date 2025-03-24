package MyCollections.FindSubtreeNodes;

import java.util.Arrays;

//有两个数组 a,b，大小都为 n,数组元素为任意整数，无序， 要求：通过交换
//a,b 中的元素，使[数组 a 元素的和]与[数组 b 元素的和]之间差的绝对值最小。
public class ArraySwap {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        minimizeDifference(a, b);
        System.out.println("数组 a: " + Arrays.toString(a));
        System.out.println("数组 b: " + Arrays.toString(b));
        int sumA = sumArray(a);
        int sumB = sumArray(b);
        System.out.println("差的绝对值: " + Math.abs(sumA - sumB));
    }

    public static void minimizeDifference(int[] a, int[] b) {
        int n = a.length;
        int diff = Integer.MAX_VALUE;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = a[i];
                    a[i] = b[j];
                    b[j] = temp;
                    int newDiff = Math.abs(sumArray(a) - sumArray(b));
                    if (newDiff < diff) {
                        diff = newDiff;
                        swapped = true;
                    } else {
                        temp = a[i];
                        a[i] = b[j];
                        b[j] = temp;
                    }
                }
            }
        }
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}    