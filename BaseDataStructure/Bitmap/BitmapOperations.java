package Bitmap;

public class BitmapOperations {

    // 设置指定位置的位为 1
    public static int setBit(int bitmap, int position) {
        return bitmap | (1 << position);
    }

    // 清除指定位置的位，将其置为 0
    public static int clearBit(int bitmap, int position) {
        return bitmap & ~(1 << position);
    }

    // 检查指定位置的位是否为 1
    public static boolean checkBit(int bitmap, int position) {
        return (bitmap & (1 << position)) != 0;
    }

    // 翻转指定位置的位
    public static int flipBit(int bitmap, int position) {
        return bitmap ^ (1 << position);
    }

    // 两个 Bitmap 的并集运算
    public static int unionBitmaps(int bitmap1, int bitmap2) {
        return bitmap1 | bitmap2;
    }

    // 两个 Bitmap 的交集运算
    public static int intersectionBitmaps(int bitmap1, int bitmap2) {
        return bitmap1 & bitmap2;
    }

    // 两个 Bitmap 的差集运算，即 bitmap1 中有但 bitmap2 中没有的元素
    public static int differenceBitmaps(int bitmap1, int bitmap2) {
        return bitmap1 & ~bitmap2;
    }

    public static void main(String[] args) {
        int bitmap = 0;

        // 设置第 2 位为 1
        bitmap = setBit(bitmap, 2);
        System.out.println("设置第 2 位为 1 后的结果: " + Integer.toBinaryString(bitmap));

        // 清除第 2 位
        bitmap = clearBit(bitmap, 2);
        System.out.println("清除第 2 位后的结果: " + Integer.toBinaryString(bitmap));

        // 检查第 2 位
        boolean isSet = checkBit(bitmap, 2);
        System.out.println("第 2 位是否为 1: " + isSet);

        // 翻转第 2 位
        bitmap = flipBit(bitmap, 2);
        System.out.println("翻转第 2 位后的结果: " + Integer.toBinaryString(bitmap));

        int bitmap1 = 6; // 二进制 0110
        int bitmap2 = 3; // 二进制 0011

        // 并集运算
        int unionResult = unionBitmaps(bitmap1, bitmap2);
        System.out.println("并集结果: " + Integer.toBinaryString(unionResult));

        // 交集运算
        int intersectionResult = intersectionBitmaps(bitmap1, bitmap2);
        System.out.println("交集结果: " + Integer.toBinaryString(intersectionResult));

        // 差集运算
        int differenceResult = differenceBitmaps(bitmap1, bitmap2);
        System.out.println("差集结果: " + Integer.toBinaryString(differenceResult));
    }
}    