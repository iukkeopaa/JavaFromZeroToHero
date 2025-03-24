package DaChangBrushUpClass.class1.class2.class1.Class4;

import java.util.ArrayList;
import java.util.List;

//数组为{3, 2, 2, 3, 1}，查询为(0, 3, 2)，意思是在数组里下标0~3这个范围上，有几个？答案返回2
//假设给你一个数组arr，对这个数组的查询非常频繁，且都给了查询组，请返回所有查询的结果
public class ArrayQuery {
    public static List<Integer> queryArray(int[] arr, int[][] queries) {
        List<Integer> results = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int target = query[2];
            int count = 0;
            for (int i = left; i <= right; i++) {
                if (arr[i] == target) {
                    count++;
                }
            }
            results.add(count);
        }
        return results;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3, 1};
        int[][] queries = {{0, 3, 2}};
        List<Integer> results = queryArray(arr, queries);
        for (int result : results) {
            System.out.println(result);
        }
    }
}    