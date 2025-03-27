package MyCollections;

import java.util.Scanner;

//题目内容
//小红酷爱圈圈字符。
//小红认为:['a,'b,d,e,g'o,p’q]这些字符为圈字符，因为它们都带有一个圆圈。
//我们认为一个字符串是圈圈字符串当前仅当这个字符串中的圈圈字符数量大于非圈圈字符数量。
//现在小红打算把这个字符串分成若干个非空字符串，请你帮助她求出这些非空字符串中最多可以有多少个圈圈字符串,
//输入描述
//一个字符串s，输入保证仅含小写字母且长度不超过10
//输出描述
//个整数，表示最多可以切出多少个圈圈字符串。
public class CircleStringSplitting {
    // 圈圈字符集合
    private static final String CIRCLE_CHARS = "abdegopq";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(maxCircleStrings(s));
        scanner.close();
    }

    // 计算最多可以切出的圈圈字符串数量
    private static int maxCircleStrings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isCircleString(s, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }

    // 判断子字符串是否为圈圈字符串
    private static boolean isCircleString(String s, int start, int end) {
        int circleCount = 0;
        int nonCircleCount = 0;
        for (int i = start; i < end; i++) {
            if (CIRCLE_CHARS.indexOf(s.charAt(i)) != -1) {
                circleCount++;
            } else {
                nonCircleCount++;
            }
        }
        return circleCount > nonCircleCount;
    }
}    