package MyCollections;

import java.util.HashMap;
import java.util.Map;

//����һ�����飬���һ��Ԫ�ص�ֵ������������ĳ��ִ�������ô�����Ԫ���ǡ������㡱��
//С���õ���һ�����飬����֪����������ж��ٸ������㣿
public class FixedPointCounter {
    public static int countFixedPoints(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // ͳ��ÿ��Ԫ�صĳ��ִ���
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int fixedPointCount = 0;
        // ���ÿ��Ԫ���Ƿ��ǲ�����
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
        System.out.println("�����в������������: " + result);
    }
}    