package DoubleArrows.Q283;

import java.util.Scanner;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        // 遍历数组，将非零元素依次移到数组前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                if (nonZeroIndex != i) {
                    nums[i] = 0;
                }
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入数组元素，以空格分隔
        System.out.println("请输入数组元素，元素之间以空格分隔:");
        String input = scanner.nextLine();
        String[] numStrings = input.split(" ");
        int[] nums = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            nums[i] = Integer.parseInt(numStrings[i]);
        }

        // 调用方法移动 0
        moveZeroes(nums);

        // 输出移动后的数组
        System.out.print("移动后的数组为: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}