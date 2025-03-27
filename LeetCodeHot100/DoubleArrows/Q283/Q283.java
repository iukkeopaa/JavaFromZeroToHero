package DoubleArrows.Q283;

import java.util.Scanner;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 下午3:08
 */
public class Q283 {

    //方法1
    //两次遍历 一次遍历将数字左移动 第二次将剩余后面的部分置为0
    public static void moveZeroes(int[] nums){
        if(nums == null){

            return;

        }


        int j= 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }

        for (int i=j;i<nums.length;i++){
            nums[i]=0;
        }
    }



    //方法2
    //双指针进行复制

    public static void moveZeroes2(int[] nums){
        if(nums == null){

            return;

        }

        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static void moveZeroes3(int[] nums) {
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
        moveZeroes3(nums);

        // 输出移动后的数组
        System.out.print("移动后的数组为: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }

}
