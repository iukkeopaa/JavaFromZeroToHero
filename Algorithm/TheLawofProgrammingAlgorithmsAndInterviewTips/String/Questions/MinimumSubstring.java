package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubstring {
    public static String findMinSubstring(String article, String[] targetWords) {
        // 用于存储目标单词及其出现次数的映射
        Map<String, Integer> targetMap = new HashMap<>();
        for (String word : targetWords) {
            targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);
        }

        // 用于存储当前窗口中目标单词的出现次数
        Map<String, Integer> windowMap = new HashMap<>();
        // 目标单词的唯一数量
        int required = targetMap.size();
        // 当前窗口中满足条件的目标单词数量
        int formed = 0;

        // 文章按空格分割成单词数组
        String[] words = article.split(" ");
        // 左右指针
        int left = 0, right = 0;
        // 最小子串的长度和起始索引
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < words.length) {
            String word = words[right];
            if (targetMap.containsKey(word)) {
                windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                if (windowMap.get(word).intValue() == targetMap.get(word).intValue()) {
                    formed++;
                }
            }

            // 尝试缩小窗口
            while (left <= right && formed == required) {
                word = words[left];
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                if (targetMap.containsKey(word)) {
                    windowMap.put(word, windowMap.get(word) - 1);
                    if (windowMap.get(word) < targetMap.get(word)) {
                        formed--;
                    }
                }
                left++;
            }
            right++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = minLeft; i < minLeft + minLen; i++) {
            if (i > minLeft) {
                result.append(" ");
            }
            result.append(words[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String article = "hello world this is a good example hello world";
        String[] targetWords = {"hello", "world", "good"};
        String minSubstring = findMinSubstring(article, targetWords);
        System.out.println("最短子串: " + minSubstring);
    }
}    