package TheLawofProgrammingAlgorithmsAndInterviewTips.Dp.Questions;

import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start;
    int end;
    int weight;

    public Activity(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class WeightedActivityScheduling {
    public static int maxProfit(Activity[] activities) {
        int n = activities.length;
        if (n == 0) {
            return 0;
        }
        // 按结束时间排序
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = activities[i].weight;
            for (int j = 0; j < i; j++) {
                if (activities[j].end <= activities[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + activities[i].weight);
                }
            }
        }
        int max = 0;
        for (int profit : dp) {
            max = Math.max(max, profit);
        }
        return max;
    }

    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 4, 5),
                new Activity(3, 5, 2),
                new Activity(0, 6, 6),
                new Activity(5, 7, 6),
                new Activity(3, 9, 4),
                new Activity(5, 9, 8),
                new Activity(6, 10, 3),
                new Activity(8, 11, 4),
                new Activity(8, 12, 7),
                new Activity(2, 14, 10),
                new Activity(12, 16, 9)
        };
        System.out.println("最大收益: " + maxProfit(activities));
    }
}    