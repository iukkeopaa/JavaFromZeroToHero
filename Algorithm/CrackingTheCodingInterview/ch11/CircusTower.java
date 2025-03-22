package CrackingTheCodingInterview.ch11;

import java.util.Arrays;
import java.util.Comparator;

class Person {
    int height;
    int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}

public class CircusTower {
    public static int maxTowerHeight(Person[] people) {
        // 先按身高排序，如果身高相同则按体重排序
        Arrays.sort(people, Comparator.comparingInt((Person p) -> p.height).thenComparingInt(p -> p.weight));

        int[] weights = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            weights[i] = people[i].weight;
        }

        return longestIncreasingSubsequence(weights);
    }

    private static int longestIncreasingSubsequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Person[] people = {
                new Person(65, 100),
                new Person(70, 150),
                new Person(56, 90),
                new Person(75, 190),
                new Person(60, 95),
                new Person(68, 110)
        };

        int maxHeight = maxTowerHeight(people);
        System.out.println("叠罗汉最多能叠 " + maxHeight + " 个人。");
    }
}    