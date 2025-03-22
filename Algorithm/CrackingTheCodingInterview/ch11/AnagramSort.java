package CrackingTheCodingInterview.ch11;

import java.util.*;

public class AnagramSort {
    public static void sortAnagrams(String[] array) {
        // 创建一个映射，用于存储排序后的字符串及其对应的原始字符串列表
        Map<String, List<String>> map = new HashMap<>();

        // 遍历数组中的每个字符串
        for (String str : array) {
            // 将字符串转换为字符数组
            char[] charArray = str.toCharArray();
            // 对字符数组进行排序
            Arrays.sort(charArray);
            // 将排序后的字符数组转换为字符串，作为键
            String key = new String(charArray);

            // 如果映射中不包含该键，则创建一个新的列表
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 将原始字符串添加到对应的列表中
            map.get(key).add(str);
        }

        // 用于记录当前的索引
        int index = 0;
        // 遍历映射中的每个键
        for (String key : map.keySet()) {
            // 获取该键对应的字符串列表
            List<String> list = map.get(key);
            // 将列表中的字符串依次放回原数组
            for (String str : list) {
                array[index++] = str;
            }
        }
    }

    public static void main(String[] args) {
        String[] array = {"acre", "race", "care", "bat", "tab", "act"};
        sortAnagrams(array);
        System.out.println(Arrays.toString(array));
    }
}    