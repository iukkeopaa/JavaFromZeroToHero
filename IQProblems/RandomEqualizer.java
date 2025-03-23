import java.util.Random;

//两种输出结果的不等概率随机函数转化为等概率随机函数
public class RandomEqualizer {

    // 模拟不等概率随机函数，以概率 p 输出 0，以概率 1 - p 输出 1
    public static int randBiased(double p) {
        Random random = new Random();
        return random.nextDouble() < p ? 0 : 1;
    }

    // 将不等概率随机函数转化为等概率随机函数
    public static int randUnbiased(double p) {
        while (true) {
            int first = randBiased(p);
            int second = randBiased(p);
            if (first == 0 && second == 1) {
                return 0;
            } else if (first == 1 && second == 0) {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        double p = 0.3; // 假设 p 为 0.3
        int count0 = 0;
        int count1 = 0;
        int numTrials = 10000;
        for (int i = 0; i < numTrials; i++) {
            int result = randUnbiased(p);
            if (result == 0) {
                count0++;
            } else {
                count1++;
            }
        }
        System.out.println("输出 0 的概率: " + (double) count0 / numTrials);
        System.out.println("输出 1 的概率: " + (double) count1 / numTrials);
    }
}