package MyCollections.FindSubtreeNodes;

//牛顿迭代法解方程
//然后写完了，就问了问牛顿迭代法适用于什么
public class NewtonMethod {

    // 定义函数 f(x)
    public static double function(double x) {
        return x * x - 4;
    }

    // 定义函数 f(x) 的导数 f'(x)
    public static double derivative(double x) {
        return 2 * x;
    }

    // 牛顿迭代法求解方程的根
    public static double newtonMethod(double initialGuess, double tolerance, int maxIterations) {
        double x = initialGuess;
        int iteration = 0;

        while (iteration < maxIterations) {
            double fx = function(x);
            double fPrimeX = derivative(x);

            // 检查导数是否为零，避免除零错误
            if (Math.abs(fPrimeX) < tolerance) {
                System.out.println("导数接近零，无法继续迭代。");
                return Double.NaN;
            }

            double nextX = x - fx / fPrimeX;

            // 检查是否满足收敛条件
            if (Math.abs(nextX - x) < tolerance) {
                return nextX;
            }

            x = nextX;
            iteration++;
        }

        System.out.println("达到最大迭代次数，可能未收敛。");
        return Double.NaN;
    }

    public static void main(String[] args) {
        double initialGuess = 1.0;
        double tolerance = 1e-6;
        int maxIterations = 100;

        double root = newtonMethod(initialGuess, tolerance, maxIterations);
        if (!Double.isNaN(root)) {
            System.out.println("方程的根是: " + root);
        }
    }
}