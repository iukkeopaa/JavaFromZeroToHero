package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNumberPairs {
    public static List<int[]> findPairs(int[] arr) {
        List<int[]> pairs = new ArrayList<>();
        Map<Integer, Boolean> numMap = new HashMap<>();

        // 将数组元素存入哈希表
        for (int num : arr) {
            numMap.put(num, true);
        }

        // 遍历数组，查找满足 2a = b 的数对
        for (int a : arr) {
            int b = 2 * a;
            if (numMap.containsKey(b)) {
                pairs.add(new int[]{a, b});
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8};
        List<int[]> pairs = findPairs(arr);

        // 输出满足条件的数对
        for (int[] pair : pairs) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}    