package MyCollections;

import java.util.Scanner;

//题目内容
//小红在一维度的世界中，她可以向左或者向右移动。她拿到一个长度为n的字符串s，仅包含'<'和">'两种字符，'<' 表
//示向左移动，'>'表示向右移动。
//小红想知道，如果从字符串s的第i(0 <i< n)个字符开始,然后按照S,S:+1,S+2,….的顺序依次移动，那么小红有:
//有九会回到原地。
//值得注意的是，你需要对于任意的i(0<i< n)都判断是否存在一种移动方式，使得小红可以回到原地且不一定需要
//执行到sn-1，每个的判断互不影响。
//输入描述
//第一行一个整数n(1 ≤n≤2 x 10'),表示字符串s的长度。
//第二行一个字符串s，仅包含'<'和'>'两种字符。
//输出描述
//输出几个整数，第i个整数表示从第i个字符开始移动，小红有没有机会回到原地，若有机会输出1，否则输出0。
public class RedMovementJudgment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print(canReturnToOrigin(s, i)? 1 : 0);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        scanner.close();
    }

    public static boolean canReturnToOrigin(String s, int start) {
        int balance = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                balance--;
            } else {
                balance++;
            }
            if (balance == 0) {
                return true;
            }
        }
        return false;
    }
}    