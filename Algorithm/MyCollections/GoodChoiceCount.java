package MyCollections;

import java.util.Scanner;

//题目内容
//小欧有一个大小为n的数组[a1,a2,….an,
//她可以选择一个元素，将它变成它的相反数a:→(-1)xa.。若此时数组
//之和在区间0,内，则这个选择是好的。
//小欧想知道有多少种选择是好的。
//输入描述
//第一行输入两个整数n,t(1 <n< 2x 10“;1 ≤t< 4x 1018)代表数组中的元素数量和区间限制。
//第二行输入几个整数a1,42,…,“n(-2 x10° ≤ a≤ 2x10°)代表数组元素。
//输出描述
//在一行上输出一个整数，表示好的选择的数量
public class GoodChoiceCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组元素数量 n 和区间上限 t
        int n = scanner.nextInt();
        long t = scanner.nextLong();

        // 用于存储数组元素
        long[] array = new long[n];
        // 存储数组元素的总和
        long totalSum = 0;

        // 读取数组元素并计算总和
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
            totalSum += array[i];
        }

        // 用于记录好的选择的数量
        int validChoices = 0;

        // 遍历数组，尝试将每个元素取反
        for (int i = 0; i < n; i++) {
            // 计算将当前元素取反后的数组总和
            long newSum = totalSum - 2 * array[i];
            // 检查新的总和是否在区间 [0, t] 内
            if (newSum >= 0 && newSum <= t) {
                validChoices++;
            }
        }

        // 输出好的选择的数量
        System.out.println(validChoices);

        scanner.close();
    }
}    