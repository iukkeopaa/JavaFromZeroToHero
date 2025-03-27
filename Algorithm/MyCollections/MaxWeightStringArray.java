package MyCollections;

import java.util.*;

//题目内容
//小红拿到一个长度为n的字符串数组，每个字符串由若干个小写字母组成。
//定义一个字符串数组的权值为最长连续相同字符串的区间长度。
//烹想知道，若恰好删除一段连续非空区间，剩下的字符串数组的权值最大是多少,
//输入描述
//第一行一个整数n(2 ≤ n≤ 10”)，表示字符串数组的长度。
//接下来n 行，每行一个字符串，保证仅由小写字母组成。
//保证所有字符串的长度之和不超过106
//输出描述
//个整数，表示删除一段连续非空区间后，剩下的字符串数组的权值最大是多少。
public class MaxWeightStringArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        scanner.close();

        int maxWeight = calculateMaxWeight(strings);
        System.out.println(maxWeight);
    }

    public static int calculateMaxWeight(String[] strings) {
        // 存储每种字符串对应的连续段长度列表
        Map<String, List<Integer>> segments = new HashMap<>();
        int i = 0;
        while (i < strings.length) {
            String current = strings[i];
            int count = 1;
            i++;
            while (i < strings.length && strings[i].equals(current)) {
                count++;
                i++;
            }
            segments.computeIfAbsent(current, k -> new ArrayList<>()).add(count);
        }

        int maxWeight = 0;
        // 遍历每种字符串对应的连续段长度列表
        for (List<Integer> lengths : segments.values()) {
            if (lengths.size() > 1) {
                // 降序排序
                lengths.sort(Collections.reverseOrder());
                // 取前两大的长度相加并更新最大权值
                maxWeight = Math.max(maxWeight, lengths.get(0) + lengths.get(1));
            }
        }

        // 特判所有字符串都相同的情况
        boolean allSame = true;
        for (i = 1; i < strings.length; i++) {
            if (!strings[i].equals(strings[0])) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            maxWeight = Math.max(maxWeight, strings.length - 1);
        }

        return maxWeight;
    }
}    