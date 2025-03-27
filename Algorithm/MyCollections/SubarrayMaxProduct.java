package MyCollections;
//题目内容
//小苯有一个长度为n的数组a。他定义:
//f(a)= a1 + a2 + …. + an。(即所有数字的异或和).
//g(a)= gcd(a1,a2,·,a?)。(即所有数字的最大公约数)。
//现在小苯希望你从a中选择一个非空子数组b(子数组需满足连续)，满足子数组的f(b)·g(b)尽可能大，请你帮他算一算
//这个最大值吧。
public class SubarrayMaxProduct {
    // 计算两个数的最大公约数
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int maxProduct(int[] a) {
        int n = a.length;
        int maxProduct = Integer.MIN_VALUE;
        int maxElement = Integer.MIN_VALUE;

        // 找出数组中的最大元素
        for (int num : a) {
            maxElement = Math.max(maxElement, num);
        }

        // 最大元素的平方是一个潜在的最大值
        maxProduct = Math.max(maxProduct, maxElement * maxElement);

        // 枚举所有可能的子数组
        for (int i = 0; i < n; i++) {
            int xorSum = 0;
            int currentGcd = a[i];
            for (int j = i; j < n; j++) {
                xorSum ^= a[j];
                // 更新当前子数组的最大公约数
                if (j == i) {
                    currentGcd = a[i];
                } else {
                    currentGcd = gcd(currentGcd, a[j]);
                }
                int product = xorSum * currentGcd;
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println("最大的 f(b)·g(b) 值为: " + maxProduct(a));
    }
}