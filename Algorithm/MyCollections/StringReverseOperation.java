package MyCollections;

import java.util.Scanner;

//题目内容
//米小游有一个长度为 n 的字符串 s，下标从 1开始。
//定义对一个区间〖,"执行翻转操作为将原来的
//S1Sl+181+2...8,-18,变为8,8r-1...S1-181。
//她现在准备选定 4 个 整数 a,b,c,d(1 <a≤b≤c≤d≤ n)，然后先对区间[a,b执行翻转操作，然后再对区间
//℃,d 执行翻转操作。如果操作完成之后，现在的字符串和初始字符串能够保持相同，输出“YES”，然后输出这样的 4
//个整数，若有多组解，输出任意一个满足条件的解。否则输出"NO"。
//输入描述
//第一行一个整数 n(1 ≤n≤ 10”)，表示字符串长度。
//第二行一个长度为n的字符串 s，保证输入仅由小写字母组成。
//输出描述
//若可以满足题意，第一行输出" YES"，第二行输出4个整数，代表a,b,c,d，以空格隔开，若有多组解，输出任意-
//个。
//若不能，输出”NO
public class StringReverseOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                // 先尝试 [a, b] 区间翻转两次
                if (isValid(s, a, b, a, b)) {
                    System.out.println("YES");
                    System.out.println(a + " " + b + " " + a + " " + b);
                    scanner.close();
                    return;
                }

                // 尝试寻找对称区间
                int len = b - a + 1;
                int c = b + 1;
                int d = c + len - 1;
                if (d <= n && isValid(s, a, b, c, d)) {
                    System.out.println("YES");
                    System.out.println(a + " " + b + " " + c + " " + d);
                    scanner.close();
                    return;
                }
            }
        }
        System.out.println("NO");
        scanner.close();
    }

    public static boolean isValid(String s, int a, int b, int c, int d) {
        String temp = reverse(reverse(s, a, b), c, d);
        return temp.equals(s);
    }

    public static String reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder(s);
        String sub = sb.substring(start - 1, end);
        sb.replace(start - 1, end, new StringBuilder(sub).reverse().toString());
        return sb.toString();
    }
}    