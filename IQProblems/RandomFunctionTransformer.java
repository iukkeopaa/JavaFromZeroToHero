import java.util.Random;

///如何用a~b的随机函数加工出c~d的随机函数
public class RandomFunctionTransformer {

    // 模拟生成 [a, b] 随机数的函数
    public static int randomAtoB(int a, int b) {
        Random random = new Random();
        return random.nextInt(b - a + 1) + a;
    }

    // 用 randomAtoB 生成 [c, d] 的随机数
    public static int randomCtoD(int a, int b, int c, int d) {
        int originalRange = b - a + 1;
        int targetRange = d - c + 1;

        int k = 1;
        while (Math.pow(originalRange, k) < targetRange) {
            k++;
        }

        while (true) {
            int num = 0;
            for (int i = 0; i < k; i++) {
                num = num * originalRange + (randomAtoB(a, b) - a);
            }

            if (num < (int) (Math.pow(originalRange, k) / targetRange) * targetRange) {
                return num % targetRange + c;
            }
        }
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 5;
        int c = 1;
        int d = 7;
        // 测试生成 20 个 [c, d] 的随机数
        for (int i = 0; i < 20; i++) {
            System.out.println(randomCtoD(a, b, c, d));
        }
    }
}