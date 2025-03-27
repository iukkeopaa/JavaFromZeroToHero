package Hash.Q128;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 将数组元素存入哈希集合，方便快速查找
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // 遍历集合中的每个元素
        for (int num : numSet) {
            // 只有当当前数字是一个连续序列的起始数字时才进行后续计算
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 不断检查下一个连续数字是否存在于集合中
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // 更新最长连续序列的长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入整数数组，以空格分隔
        System.out.println("请输入整数数组，整数之间以空格分隔:");
        String input = scanner.nextLine();
        String[] numStrings = input.split(" ");
        int[] nums = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            nums[i] = Integer.parseInt(numStrings[i]);
        }

        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int result = solution.longestConsecutive(nums);
        System.out.println("数字连续的最长序列的长度是: " + result);

        scanner.close();
    }
}