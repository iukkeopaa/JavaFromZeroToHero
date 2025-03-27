package Hash.Q1;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 上午11:16
 */


//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
//
//你可以按任意顺序返回答案。


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1 {
    public static int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表，用于存储数组元素及其对应的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素与目标值的差值
            int complement = target - nums[i];
            // 检查哈希表中是否存在该差值
            if (map.containsKey(complement)) {
                // 如果存在，返回差值对应的下标和当前元素的下标
                return new int[]{map.get(complement), i};
            }
            // 将当前元素及其下标存入哈希表
            map.put(nums[i], i);
        }
        // 如果没有找到符合条件的元素，返回空数组
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入数组元素，以空格分隔
        System.out.println("请输入数组元素，以空格分隔:");
        String input = scanner.nextLine();
        String[] numStrings = input.split(" ");
        int[] nums = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            nums[i] = Integer.parseInt(numStrings[i]);
        }

        // 提示用户输入目标值
        System.out.println("请输入目标值:");
        int target = scanner.nextInt();

        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("找到的两个数的下标分别为: " + result[0] + " 和 " + result[1]);
        } else {
            System.out.println("未找到符合条件的两个数。");
        }

        scanner.close();
    }
}