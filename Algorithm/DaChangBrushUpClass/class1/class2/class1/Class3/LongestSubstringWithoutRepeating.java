package DaChangBrushUpClass.class1.class2.class1.Class3;

import java.util.HashMap;
import java.util.Map;

//求一个字符串中，最长无重复字符子串长度
public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        // 用于存储字符及其最后出现的索引
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // 如果字符已经在 map 中，并且其最后出现的索引在当前滑动窗口内
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                // 移动左指针到重复字符的下一个位置
                left = charIndexMap.get(currentChar) + 1;
            }
            // 更新字符的最后出现索引
            charIndexMap.put(currentChar, right);
            // 计算当前滑动窗口的长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("最长无重复字符子串的长度是: " + result);
    }
}    