package MyCollections;

import java.util.HashSet;
import java.util.Set;

//小美有一个长度为n的字符串s，她想知道这个字符串有多少个长度大于1的子串是可镜像的。
//可镜像的意思是:一个字符串是回文串，且其中每个字符都有垂直对称轴。
//[回文串]一个字符串被称作回文串，当且仅当这个字符串从左往右读和从右往左读是相同的。
//有垂直对称轴的大写字母:A，HT，M,O，T"U，V'W'X'Y
public class MirrorSubstringCounter {
    // 存储有垂直对称轴的字符
    private static final Set<Character> SYMMETRIC_CHARS = new HashSet<>();
    static {
        String symmetric = "AHIMOTUVWXY";
        for (char c : symmetric.toCharArray()) {
            SYMMETRIC_CHARS.add(c);
        }
    }

    public static int countMirrorSubstrings(String s) {
        int n = s.length();
        int count = 0;
        // 遍历每个可能的中心位置
        for (int i = 0; i < n; i++) {
            // 检查奇数长度的回文串
            count += expandAroundCenter(s, i, i);
            // 检查偶数长度的回文串
            count += expandAroundCenter(s, i, i + 1);
        }
        return count;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
                && SYMMETRIC_CHARS.contains(s.charAt(left))) {
            if (right - left + 1 > 1) {
                count++;
            }
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "AHA";
        System.out.println(countMirrorSubstrings(s));
    }
}    