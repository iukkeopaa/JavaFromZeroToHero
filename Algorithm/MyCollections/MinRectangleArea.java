package MyCollections;

//塔子哥拿到了一个长度为2n的数组，她希望把数组中的元素分成n个二元组:(i,y)
//每个二元组对应平面直角坐标系的一个点，然后塔子哥希望用一个边和坐标轴平行的矩形将所有点囊括在内。塔子哥希
//望最终矩形的面积尽可能小，你能帮帮他吗?
public class MinRectangleArea {
    public static int minArea(int[] arr) {
        // 检查数组长度是否为偶数，若不是则抛出异常
        if (arr.length % 2 != 0) {
            throw new IllegalArgumentException("输入数组的长度必须为偶数");
        }
        // 若数组为空，矩形面积为 0
        if (arr.length == 0) {
            return 0;
        }
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i += 2) {
            int x = arr[i];
            int y = arr[i + 1];
            // 更新最小和最大 x 坐标
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            // 更新最小和最大 y 坐标
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
        int width = maxX - minX;
        int height = maxY - minY;

        return width * height;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        try {
            int area = minArea(arr);
            System.out.println("最小矩形的面积是: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}    