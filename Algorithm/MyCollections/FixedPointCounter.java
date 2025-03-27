package MyCollections;

import java.util.HashMap;
import java.util.Map;

//对于一个数组，如果一个元素的值等于它在数组的出现次数，那么称这个元素是“不动点”。
//小红拿到了一个数组，她想知道这个数组有多少个不动点？
public class FixedPointCounter {
    public static int countFixedPoints(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // 统计每个元素的出现次数
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int fixedPointCount = 0;
        // 检查每个元素是否是不动点
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                fixedPointCount++;
            }
        }

        return fixedPointCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        int result = countFixedPoints(arr);
        System.out.println("数组中不动点的数量是: " + result);
    }
}    