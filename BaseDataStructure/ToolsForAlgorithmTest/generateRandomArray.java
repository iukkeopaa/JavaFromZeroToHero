package ToolsForAlgorithmTest;

public class generateRandomArray {
    public static int[] generateRandomArray1(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {

        // 测试
        int[] arr = generateRandomArray1(10, 100);
    }
}
