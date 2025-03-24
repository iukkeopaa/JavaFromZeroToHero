package MyCollections.FindSubtreeNodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RainwaterProcessing {
    public static int processRainwater(List<Point> points, int k) {
        // 预处理：横坐标全部减去 k
        for (Point point : points) {
            point.x -= k;
        }

        // 按纵坐标重新排序
        Collections.sort(points, Comparator.comparingInt(p -> p.y));

        // 纵坐标更新为差分
        for (int i = points.size() - 1; i > 0; i--) {
            points.get(i).y -= points.get(i - 1).y;
        }

        // 分别求横纵坐标的比，取 max，有余数时记得 +1
        int maxRatio = 0;
        for (Point point : points) {
            if (point.y != 0) {
                int ratio = point.x / point.y;
                if (point.x % point.y != 0) {
                    ratio++;
                }
                maxRatio = Math.max(maxRatio, ratio);
            }
        }

        return maxRatio;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(10, 2));
        points.add(new Point(20, 3));
        points.add(new Point(30, 4));
        int k = 5;
        int result = processRainwater(points, k);
        System.out.println("最大比例为: " + result);
    }
}    