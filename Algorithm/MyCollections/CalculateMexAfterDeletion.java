package MyCollections;

import java.util.Scanner;

//题目内容
//小欧有一个长度为n的数组[a1,“2,…,]。现在他想知道，对于a中的每个元素，删除该元素后数组的MEX值是多少,
//请你帮他算算吧。
//数组的MEX定义为没有出现在数组中的最小非负整数，
//输入描述
//第一行输入一个整数n(2 ≤ n≤ 200000)代表数组中的元素数量。
//第二行输入n个整数a1,a2,…, a?(0 ≤ a: ≤ 10”)代表数组元素。
//输出描述
//在一行上输出几个整数，其中第i个整数表示删除a:后数组的MEX值。
public class CalculateMexAfterDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] count = new int[1000000001];

        // 读取数组元素并统计每个元素的出现次数
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            count[arr[i]]++;
        }

        // 找出原数组的 MEX 值
        int mex = 0;
        while (count[mex] > 0) {
            mex++;
        }

        // 计算并输出删除每个元素后的 MEX 值
        for (int i = 0; i < n; i++) {
            count[arr[i]]--;
            if (count[arr[i]] == 0 && arr[i] < mex) {
                int newMex = arr[i];
                System.out.print(newMex);
            } else {
                System.out.print(mex);
            }
            if (i < n - 1) {
                System.out.print(" ");
            }
            count[arr[i]]++;
        }
        System.out.println();
        scanner.close();
    }
}    