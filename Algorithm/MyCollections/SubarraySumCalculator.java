package MyCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//题目描述
//小明有一个数组，他想知道有多少连续子数组的和同时是3和5的倍数，但不是4的倍数。
//输入描述
//第一行输入一个整数 (1 <n ≤ 10°)表示数组长度。 第二行输入n个整数表示数组 α?(1 < a? < 10°)
public class SubarraySumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            for (int j = i; j < n; j++) {
                if (i != j) {
                    prefixSum += arr[j];
                }
                if (prefixSum % 3 == 0 && prefixSum % 5 == 0 && prefixSum % 4 != 0) {
                    count++;
                }
                if (j > i) {
                    prefixSum -= arr[j];
                }
            }
            prefixSum -= arr[i];
        }

        System.out.println(count);
    }
}    