package MyCollections.FindSubtreeNodes;

import java.util.*;

class StringFrequency {
    String str;
    int frequency;

    public StringFrequency(String str, int frequency) {
        this.str = str;
        this.frequency = frequency;
    }
}

//输入 n 个字符串（可能相同），按照每个字符串出现次数排序规则，问出现次数前 K 的字符
//串及其次数，和出现次数后 K 个的字符串及其次数。
public class StringFrequencySort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串的数量 n: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗掉换行符

        String[] strings = new String[n];
        System.out.println("请依次输入 " + n + " 个字符串:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        System.out.print("请输入 K 的值: ");
        int k = scanner.nextInt();

        // 统计每个字符串的出现次数
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String s : strings) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }

        // 将字符串及其出现次数存储到列表中
        List<StringFrequency> frequencyList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            frequencyList.add(new StringFrequency(entry.getKey(), entry.getValue()));
        }

        // 按出现次数排序
        frequencyList.sort((a, b) -> b.frequency - a.frequency);

        // 输出出现次数前 K 的字符串及其次数
        System.out.println("出现次数前 " + k + " 的字符串及其次数:");
        for (int i = 0; i < Math.min(k, frequencyList.size()); i++) {
            StringFrequency sf = frequencyList.get(i);
            System.out.println(sf.str + ": " + sf.frequency);
        }

        // 输出出现次数后 K 的字符串及其次数
        System.out.println("出现次数后 " + k + " 的字符串及其次数:");
        for (int i = Math.max(0, frequencyList.size() - k); i < frequencyList.size(); i++) {
            StringFrequency sf = frequencyList.get(i);
            System.out.println(sf.str + ": " + sf.frequency);
        }

        scanner.close();
    }
}    