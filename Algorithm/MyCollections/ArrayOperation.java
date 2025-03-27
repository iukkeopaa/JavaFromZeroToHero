package MyCollections;

import java.util.Scanner;

//小苯有一个长为n 的数组 a，下标从0到几-1，他可以做如下操作:
//·对于每一个i(1 <i< n)，令b; = a:|a(i+1)%n，全部执行完后，再将a数组赋值为b数组，即再执行:a;=
//bi(l ≤i≤ n)。
//小苯想知道，如果他想要a的最小值不小于k的话，最少需要执行多少次上述的操作，请你帮他算一算吧。(数据保证
//输入描述
//每个测试文件内都包含多组测试数据。
//第一行一个正整数 T(1 ≤ T < 1000)，表示测试数据的组数
//接下来对于每组测试数据，输入包含两行。
//第一行两个整数 n, k(1 ≤ n ≤ 2* 10',0 ≤た≤ 231)表示数组a的长度和最小值的限制。
//第二行 π 个整数 α? (0 < α < 231)，表示数组 a。(保证所有测试数据中 n 的总和不超过 3*10'
public class ArrayOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int operations = 0;
            boolean canReach = false;

            // 最多进行 n 次操作，因为 n 次操作后状态会循环
            for (int op = 0; op <= n; op++) {
                boolean allValid = true;
                int[] temp = new int[n];
                for (int i = 0; i < n; i++) {
                    temp[i] = a[i];
                    if (i > 0) {
                        temp[i] |= a[i - 1];
                    }
                    if (i < n - 1) {
                        temp[i] |= a[i + 1];
                    }
                    if (i == 0) {
                        temp[i] |= a[n - 1];
                    }
                    if (temp[i] < k) {
                        allValid = false;
                    }
                }
                if (allValid) {
                    operations = op;
                    canReach = true;
                    break;
                }
                a = temp;
            }

            if (canReach) {
                System.out.println(operations);
            } else {
                System.out.println(-1);
            }
        }
        scanner.close();
    }
}    