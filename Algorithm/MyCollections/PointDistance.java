package MyCollections;

import java.util.Scanner;

//小红拿到一个长度为n的数组a
//第i个元素为(;,y)，编号为i.
//定义两个点的距离为
//aist(ai,aj)=|i-yi+|yi-yj
//现在请你对于任意的i(1 <i< n)，输出距离其最大的点的距离。
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class PointDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }

        int[] max1 = new int[n];
        int[] max2 = new int[n];
        int[] max3 = new int[n];
        int[] max4 = new int[n];

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum1 = points[i].x + points[i].y;
            int sum2 = points[i].x - points[i].y;
            int sum3 = -points[i].x + points[i].y;
            int sum4 = -points[i].x - points[i].y;

            max1[i] = sum1;
            max2[i] = sum2;
            max3[i] = sum3;
            max4[i] = sum4;

            min1 = Math.min(min1, sum1);
            min2 = Math.min(min2, sum2);
            min3 = Math.min(min3, sum3);
            min4 = Math.min(min4, sum4);
        }

        for (int i = 0; i < n; i++) {
            int maxDist = 0;
            maxDist = Math.max(maxDist, max1[i] - min1);
            maxDist = Math.max(maxDist, max2[i] - min2);
            maxDist = Math.max(maxDist, max3[i] - min3);
            maxDist = Math.max(maxDist, max4[i] - min4);
            System.out.println(maxDist);
        }

        scanner.close();
    }
}    