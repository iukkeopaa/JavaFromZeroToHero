package MyCollections;

import java.util.Scanner;

//小红认为一个字符串是好字符串当且仅当这个字符串去重后按照相对顺序排列在字典序上是一个单调递增字符串。
//例如:s = aabca，去重后为abc，满足字典序单调递增。
//现在小红有一个长度为n的字符串t，请你帮助她计算有多少个非空子串是好字符串。
//去重:每种字符只保留第一个出现的位置。
//子串:子串是指一个字符串中的连续部分。
//输入描述
//第一行一个整数n(1 ≤n≤ 10”)，表示字符串长度。
//第二行一个长度为n的字符串t，保证输入只含小写字母,
//输出描述
//一个整数，表示t中有多少个子串是好字符串。
public class GoodSubstringCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String t = scanner.nextLine();
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[26];
            StringBuilder unique = new StringBuilder();
            for (int j = i; j < n; j++) {
                char c = t.charAt(j);
                if (!visited[c - 'a']) {
                    visited[c - 'a'] = true;
                    unique.append(c);
                }
                if (isMonotonicIncreasing(unique.toString())) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isMonotonicIncreasing(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) <= s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}    