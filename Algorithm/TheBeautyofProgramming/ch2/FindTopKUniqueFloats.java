package TheBeautyofProgramming.ch2;

import java.util.*;

public class FindTopKUniqueFloats {
    public static List<Float> findTopKToMUniqueFloats(float[] nums, int k, int m) {
        // 用于存储唯一的浮点数
        Set<Float> uniqueNums = new HashSet<>();
        for (float num : nums) {
            uniqueNums.add(num);
        }

        // 将唯一的浮点数存储到列表中
        List<Float> uniqueList = new ArrayList<>(uniqueNums);
        // 对列表进行降序排序
        uniqueList.sort(Collections.reverseOrder());

        // 提取第 k 到第 m 大的不同浮点数
        List<Float> result = new ArrayList<>();
        int startIndex = Math.max(0, k - 1);
        int endIndex = Math.min(m, uniqueList.size());
        for (int i = startIndex; i < endIndex; i++) {
            result.add(uniqueList.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        float[] nums = {1.5f, 1.5f, 2.5f, 2.5f, 3.5f, 3.5f, 5f, 0f, -1.5f, 3.5f};
        int k = 2;
        int m = 4;
        List<Float> topKToM = findTopKToMUniqueFloats(nums, k, m);
        System.out.println(topKToM);
    }
}    