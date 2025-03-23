import java.util.Random;


//如何用1~5的随机函数加工出1~7的随机函数
public class RandomGenerator {
    // 生成1 - 5的随机数
    public static int random5() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    // 用random5生成1 - 7的随机数
    public static int random7() {
        while (true) {
            // 生成一个25种可能的随机数
            int num = (random5() - 1) * 5 + (random5() - 1);
            if (num < 21) {
                // 映射到1 - 7的范围
                return num % 7 + 1;
            }
        }
    }

    public static void main(String[] args) {
        // 测试生成20个1 - 7的随机数
        for (int i = 0; i < 20; i++) {
            System.out.println(random7());
        }
    }
}