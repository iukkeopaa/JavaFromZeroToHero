package MyCollections;

import java.util.Scanner;

//题目内容
//小红有n种粘合剂，第i种粘合剂的粘合度为44。 他会从中挑选k(1 <k< n)种粘合剂组合使用,记桃选的k种粘合剂依
//次为a,4…, ,，那么,组合粘合变为所选粘合剂初始粘合度的最大公因数god(a,4,,),当k = 1时,此时组
//合粘合度为a6
//现在小红想询问搭配使用粘合剂的最低和最高粘合度为多少?
//最大公因数，指两个整数共有约数中最大的一个。例如，12和30的公约数有1,2.3.6，其中最大的约数是6，因此
//god(12,30)=6.
//输入描述
//第一行一个整数n(1 ≤ n≤ 10'),表示粘合剂种数。
//第二行几个整数，第i个整数为a;(1 < a< 10°),表示第i种粘合剂的粘合度。
//输出描述
//两个整数，以空格隔开，分别表示对一个物品任意搭配使用粘合剂的最低和最高粘合度。
public class AdhesiveBondingDegree {
    // 计算两个数的最大公因数
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] adhesives = new int[n];
        int maxDegree = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            adhesives[i] = scanner.nextInt();
            if (adhesives[i] > maxDegree) {
                maxDegree = adhesives[i];
            }
        }

        int minDegree = adhesives[0];
        for (int i = 1; i < n; i++) {
            minDegree = gcd(minDegree, adhesives[i]);
        }

        System.out.println(minDegree + " " + maxDegree);
    }
}    