package Hash.Q2;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个哈希表，用于存储排序后的字符串和对应的字母异位词组
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // 将字符串转换为字符数组
            char[] charArray = str.toCharArray();
            // 对字符数组进行排序
            Arrays.sort(charArray);
            // 将排序后的字符数组转换为字符串，作为哈希表的键
            String sortedStr = new String(charArray);

            // 如果哈希表中不存在该键，则创建一个新的列表
            anagramMap.computeIfAbsent(sortedStr, k -> new ArrayList<>());
            // 将原始字符串添加到对应的列表中
            anagramMap.get(sortedStr).add(str);
        }

        // 将哈希表中的所有列表收集到一个结果列表中
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入字符串数组，以空格分隔
        System.out.println("请输入字符串数组，字符串之间以空格分隔:");
        String input = scanner.nextLine();
        String[] strs = input.split(" ");

        GroupAnagrams solution = new GroupAnagrams();
        List<List<String>> result = solution.groupAnagrams(strs);

        // 输出结果
        System.out.println("字母异位词组如下：");
        for (List<String> group : result) {
            System.out.println(group);
        }

        scanner.close();
    }
}