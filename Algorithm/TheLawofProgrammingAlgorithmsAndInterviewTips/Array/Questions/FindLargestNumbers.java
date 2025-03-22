package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.PriorityQueue;

public class FindLargestNumbers {
    public static int[] findTop500(int[][] arrays) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new int[]{arrays[i][0], i, 0});
            }
        }

        int[] result = new int[500];
        for (int i = 0; i < 500; i++) {
            int[] current = minHeap.poll();
            result[i] = current[0];
            int arrayIndex = current[1];
            int elementIndex = current[2];
            if (elementIndex + 1 < arrays[arrayIndex].length) {
                minHeap.offer(new int[]{arrays[arrayIndex][elementIndex + 1], arrayIndex, elementIndex + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = new int[20][500];
        // 这里可以添加代码来初始化 20 个数组，每个数组 500 个降序排列的数

        int[] top500 = findTop500(arrays);
        for (int num : top500) {
            System.out.println(num);
        }
    }
}    