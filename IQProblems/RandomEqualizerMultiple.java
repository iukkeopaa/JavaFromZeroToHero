import java.util.Random;

//多种输出结果的不等概率随机函数转化为等概率随机函数
public class RandomEqualizerMultiple {

    // 模拟不等概率随机函数，输出 0、1、2，概率分别为 0.2、0.3、0.5
    public static int randBiasedMultiple() {
        Random random = new Random();
        double r = random.nextDouble();
        if (r < 0.2) {
            return 0;
        } else if (r < 0.5) {
            return 1;
        } else {
            return 2;
        }
    }

    // 将不等概率随机函数转化为等概率随机函数
    public static int randUnbiasedMultiple() {
        while (true) {
            int result1 = randBiasedMultiple();
            int result2 = randBiasedMultiple();
            int result3 = randBiasedMultiple();
            int combinedResult = result1 * 9 + result2 * 3 + result3;
            if (combinedResult < 27) {
                return combinedResult % 3;
            }
        }
    }

    public static void main(String[] args) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int numTrials = 10000;
        for (int i = 0; i < numTrials; i++) {
            int result = randUnbiasedMultiple();
            if (result == 0) {
                count0++;
            } else if (result == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        System.out.println("输出 0 的概率: " + (double) count0 / numTrials);
        System.out.println("输出 1 的概率: " + (double) count1 / numTrials);
        System.out.println("输出 2 的概率: " + (double) count2 / numTrials);
    }
}