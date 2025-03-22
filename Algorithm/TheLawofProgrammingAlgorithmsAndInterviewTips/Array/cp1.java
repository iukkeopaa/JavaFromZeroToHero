package TheLawofProgrammingAlgorithmsAndInterviewTips.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class cp1 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k == 0) {
            return new int[0];
        }
        // 创建一个最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }
        // 将堆中的元素存入数组
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;
        int[] result = getLeastNumbers(arr, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}



class TripleQuerySolution {
    public static int[] solveQueries(int[] sequence, int[][] queries) {
        int[] results = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int i = queries[q][0] - 1;
            int j = queries[q][1];
            int k = queries[q][2] - 1;

            // 提取子数组
            int[] subSequence = Arrays.copyOfRange(sequence, i, j);
            // 对子数组进行排序
            Arrays.sort(subSequence);
            // 找到第 k 个数
            results[q] = subSequence[k];
        }
        return results;
    }

    public static void main(String[] args) {
        int[] sequence = {1, 5, 2, 6, 3, 7, 4};
        int[][] queries = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] results = solveQueries(sequence, queries);
        for (int result : results) {
            System.out.println(result);
        }
    }
}