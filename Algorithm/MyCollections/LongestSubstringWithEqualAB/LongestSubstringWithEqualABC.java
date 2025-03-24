package MyCollections.FindSubtreeNodes.LongestSubstringWithEqualAB;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithEqualABC {
    public static int longestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        // 用于存储当前字符 a、b、c 的数量差
        int countA = 0, countB = 0, countC = 0;
        // 存储每种状态第一次出现的索引
        Map<String, Integer> stateIndexMap = new HashMap<>();
        stateIndexMap.put("0_0_0", -1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                countA++;
            } else if (c == 'b') {
                countB++;
            } else if (c == 'c') {
                countC++;
            }
            // 计算当前状态
            String state = (countA - countB) + "_" + (countA - countC);
            if (stateIndexMap.containsKey(state)) {
                int startIndex = stateIndexMap.get(state);
                maxLength = Math.max(maxLength, i - startIndex);
            } else {
                stateIndexMap.put(state, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println("最长子串长度: " + longestSubstring(s));
    }
}    