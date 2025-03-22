package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

import java.util.Arrays;

public class LongestRepeatedSubstring {
    public static String longestRepeatedSubstring(String str) {
        int n = str.length();
        // 生成后缀数组
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = str.substring(i);
        }
        // 对后缀数组进行排序
        Arrays.sort(suffixes);

        String longest = "";
        for (int i = 0; i < n - 1; i++) {
            // 找出相邻后缀的最长公共前缀
            String commonPrefix = commonPrefix(suffixes[i], suffixes[i + 1]);
            if (commonPrefix.length() > longest.length()) {
                longest = commonPrefix;
            }
        }
        return longest;
    }

    private static String commonPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, minLength);
    }

    public static void main(String[] args) {
        String str1 = "abczzacbca";
        String str2 = "canffcancd";
        System.out.println(longestRepeatedSubstring(str1)); 
        System.out.println(longestRepeatedSubstring(str2)); 
    }
}    