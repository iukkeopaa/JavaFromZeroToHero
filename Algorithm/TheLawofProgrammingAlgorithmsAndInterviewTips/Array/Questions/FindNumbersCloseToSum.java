package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.ArrayList;
import java.util.List;

public class FindNumbersCloseToSum {
    // 用于存储最接近的组合
    private static List<Double> closestCombination = new ArrayList<>();
    // 存储最接近的和
    private static double closestSum = Double.MAX_VALUE;

    public static List<Double> findClosestNumbers(double[] numbers, double m) {
        int n = numbers.length;
        // 生成所有可能的组合
        for (int i = 0; i < (1 << n); i++) {
            List<Double> currentCombination = new ArrayList<>();
            double currentSum = 0;
            // 遍历每一位
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    currentCombination.add(numbers[j]);
                    currentSum += numbers[j];
                }
            }
            // 如果当前和更接近目标值
            if (Math.abs(currentSum - m) < Math.abs(closestSum - m)) {
                closestSum = currentSum;
                closestCombination = new ArrayList<>(currentCombination);
            }
        }
        return closestCombination;
    }

    public static void main(String[] args) {
        double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};
        double m = 7.5;
        List<Double> result = findClosestNumbers(numbers, m);
        System.out.println("最接近的组合: " + result);
        System.out.println("组合的和: " + closestSum);
    }
}    