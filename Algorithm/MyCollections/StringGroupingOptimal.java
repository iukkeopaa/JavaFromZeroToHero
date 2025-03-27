package MyCollections;

import java.util.Scanner;

//题目内容
//米小游有 n 个长度为 m 且仅由小写字母组成的字符串。
//定义两个字符串 p,q 的差异值为》”。[p:≠ q]，其中表达式中的括号为艾弗森括号，表达式成立时为1，否则为0。
//若两个字符串的差异值小于等于k，那么两个字符串属于一个团。
//现在请你帮助米小游计算能否将这 n个字符串归为一个完整的团，若可以输出"YES”，否则输出”NO”，再输出需要删
//除多少个字符串。
//输入描述
//第一行一个整数 T(1 < T < 100)，表示单个测试文件的数据组数。
//对于每一组数据格式为:
//第一行三个整数n,m,k(1≤n≤500,1≤k≤m≤500)
//接下来 几 行，每行一个长度为m 的字符串，输入仅由小写字母组成。
//单个测试文件保证》n < 500。
public class StringGroupingOptimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取测试用例的数量

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt(); // 字符串的数量
            int m = scanner.nextInt(); // 字符串的长度
            int k = scanner.nextInt(); // 差异值阈值
            scanner.nextLine(); // 消耗掉 nextInt() 后的换行符

            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.nextLine();
            }

            boolean canGroup = true;
            String firstString = strings[0];

            // 只将每个字符串和第一个字符串比较
            for (int i = 1; i < n; i++) {
                int diff = calculateDifference(firstString, strings[i]);
                if (diff > k) {
                    canGroup = false;
                    break;
                }
            }

            if (canGroup) {
                System.out.println("YES");
            } else {
                System.out.println("NO " + (n - 1));
            }
        }
        scanner.close();
    }

    // 计算两个字符串的差异值
    private static int calculateDifference(String p, String q) {
        int diff = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != q.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}    