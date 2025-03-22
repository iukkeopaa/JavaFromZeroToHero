package MyCollections.FindSubtreeNodes;

//实现 sqrt 函数
public class SqrtFunction {
    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("不能对负数求平方根");
        }
        if (x == 0 || x == 1) {
            return x;
        }
        double left = 0;
        double right = x;
        double precision = 1e-7;
        while (right - left > precision) {
            double mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        double num = 16;
        double result = sqrt(num);
        System.out.println("数字 " + num + " 的平方根是: " + result);
    }
}    