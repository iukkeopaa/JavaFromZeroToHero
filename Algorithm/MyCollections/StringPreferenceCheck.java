package MyCollections;

import java.util.Scanner;

//题目内容
//小红很喜欢字将串s，如果字符串t的某一个长度至少为k的前缀或某一个长度至少为k的后缀是s的子串，那么小红也会
//喜欢字符串t。
//例如，k= 2时，小红喜欢字符串hello那么小红也喜欢字符"ciallo","he”，因为"ciallo”的长度为2的后缀"lo"he"的长
//度为2的前缀"he“都是"hello”的子串，但小红不喜欢字符串"s!0”，因为"so!0"的任何一个前缀、后缀都不是"hello”的
//子串。
//小红有一个字符串喜欢的s，她每次会问你，字符串t她是否喜欢。
//输入描述
//第一行输入一个长度不超过10”的只由小写字母构成的字符串。
//第二行输入两个正整数q(1 ≤q≤ 10“),k(1 ≤ k ≤ 10)表示询问次数和长度限制,
//接下来q行，每行输入一个只由小写字母构成的字符串t表示询问。
//数据保证，所有的字符串t的长度之和不超过105
//输出描述
//对每个询问输出一行，若小红喜欢字符串t，输出“YES"，否则输出"NO"
public class StringPreferenceCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int q = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            String t = scanner.nextLine();
            System.out.println(isPreferred(s, t, k)? "YES" : "NO");
        }
        scanner.close();
    }

    private static boolean isPreferred(String s, String t, int k) {
        int len = t.length();
        if (len < k) {
            return false;
        }

        return checkSubstring(s, t, 0, k) || checkSubstring(s, t, len - k, len);
    }

    private static boolean checkSubstring(String s, String t, int start, int end) {
        for (int i = 0; i <= s.length() - (end - start); i++) {
            boolean match = true;
            for (int j = 0; j < end - start; j++) {
                if (s.charAt(i + j) != t.charAt(start + j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
    