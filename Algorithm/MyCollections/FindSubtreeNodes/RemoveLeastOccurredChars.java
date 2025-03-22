package MyCollections.FindSubtreeNodes;

import java.util.HashMap;
import java.util.Map;

//输入一个字符串，删除其中出现次数最少的字符然后输出，出现次数最少的字符可能不止
//一个，不打乱原来的顺序
public class RemoveLeastOccurredChars {
    public static String removeLeastFrequentChars(String s) {
        // 用于存储每个字符及其出现的次数
        Map<Character, Integer> charCount = new HashMap<>();
        // 遍历字符串，统计每个字符的出现次数
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        // 找出最少的出现次数
        int minCount = Integer.MAX_VALUE;
        for (int count : charCount.values()) {
            if (count < minCount) {
                minCount = count;
            }
        }
        StringBuilder result = new StringBuilder();
        // 再次遍历字符串，将出现次数不是最少的字符添加到结果中
        for (char c : s.toCharArray()) {
            if (charCount.get(c) > minCount) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "hello world";
        String output = removeLeastFrequentChars(input);
        System.out.println("处理后的字符串: " + output);
    }
}    