package CrackingTheCodingInterview.ch6;

public class FindHeavierPillBottle {
    public static int findHeavierBottle(double[] weights) {
        double expectedWeight = 0;
        for (int i = 1; i <= weights.length; i++) {
            expectedWeight += i * 1;
        }

        double actualWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            actualWeight += (i + 1) * weights[i];
        }

        double difference = actualWeight - expectedWeight;
        return (int) (difference / 0.1);
    }

    public static void main(String[] args) {
        double[] weights = new double[20];
        // 假设第 5 瓶是较重的那瓶
        for (int i = 0; i < weights.length; i++) {
            if (i == 4) {
                weights[i] = 1.1;
            } else {
                weights[i] = 1;
            }
        }
        int heavierBottle = findHeavierBottle(weights);
        System.out.println("较重的药丸瓶是第 " + heavierBottle + " 瓶。");
    }
}    