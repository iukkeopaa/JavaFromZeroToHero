package DaChangBrushUpClass.Class4;

import java.util.*;

//大楼轮廓线问题
//Leetcode题目：https://leetcode.com/problems/the-skyline-problem/
class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        // 拆解每个大楼的起始点和结束点
        for (int[] building : buildings) {
            // 起始点高度设为负，表示开始
            height.add(new int[]{building[0], -building[2]});
            // 结束点高度设为正，表示结束
            height.add(new int[]{building[1], building[2]});
        }
        // 按 x 坐标排序，如果 x 坐标相同，按高度排序
        height.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        // 优先队列存储当前的最大高度
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prevMaxHeight = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                // 遇到起始点，加入高度
                pq.offer(-h[1]);
            } else {
                // 遇到结束点，移除高度
                pq.remove(h[1]);
            }
            int currentMaxHeight = pq.peek();
            if (prevMaxHeight != currentMaxHeight) {
                // 高度发生变化，记录轮廓点
                result.add(Arrays.asList(h[0], currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SkylineProblem solution = new SkylineProblem();
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        List<List<Integer>> skyline = solution.getSkyline(buildings);
        for (List<Integer> point : skyline) {
            System.out.println(point);
        }
    }
}    