package TheLawofProgrammingAlgorithmsAndInterviewTips.String;

public class cp1_6 {
    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以单个字符为中心扩展
            int len1 = expandAroundCenter(s, i, i);
            // 以两个字符为中心扩展
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            maxLength = Math.max(maxLength, len);
        }
        return maxLength;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println("最长回文子串的长度是: " + longestPalindrome(s));
    }
}

class LongestPalindromicSubstrings {
    public static String longestPalindromicSubstrings(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int maxLength = 1;
            int end = i;
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j) && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    end = j;
                }
            }
            if (result.length() > 0) {
                result.append(",");
            }
            result.append(s.substring(i, end + 1));
            i = end + 1;
        }
        return result.toString();
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "habbafgh";
        System.out.println(longestPalindromicSubstrings(input));
    }
}