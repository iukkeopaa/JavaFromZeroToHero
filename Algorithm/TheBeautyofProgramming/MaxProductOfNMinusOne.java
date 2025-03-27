package TheBeautyofProgramming;

public class MaxProductOfNMinusOne {
    public static long maxProduct(int[] arr) {
        int n = arr.length;
        // 用于存储从左到右的累积乘积
        long[] leftProducts = new long[n];
        // 用于存储从右到左的累积乘积
        long[] rightProducts = new long[n];

        // 计算从左到右的累积乘积
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * arr[i - 1];
        }

        // 计算从右到左的累积乘积
        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * arr[i + 1];
        }

        // 初始化最大乘积为负无穷
        long maxProduct = Long.MIN_VALUE;
        // 计算每个 (N - 1) 个数的组合乘积
        for (int i = 0; i < n; i++) {
            long currentProduct = leftProducts[i] * rightProducts[i];
            maxProduct = Math.max(maxProduct, currentProduct);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        long result = maxProduct(arr);
        System.out.println("最大的 (N - 1) 个数的组合乘积是: " + result);
    }
}    