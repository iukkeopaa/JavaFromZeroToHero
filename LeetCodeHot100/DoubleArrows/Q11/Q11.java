package DoubleArrows.Q11;

import java.util.Scanner;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 下午3:25
 */
public class Q11 {

    public static int maxArea(int[] nums){

        int low =0;
        int high=nums.length-1;
        int maxarea=0;


        while(low<high){

            int currentmaxarea=Math.min(nums[low],nums[high])*(high-low);

            maxarea=Math.max(maxarea,currentmaxarea);

            if(nums[low]<nums[high]){
                low++;
            }else {
                high--;
            }


        }

        return maxarea;

    }

//    public static void main(String[] args) {
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int result = maxArea(height);
//        System.out.println("容器可以储存的最大水量是: " + result);
//    }
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("请输入整数数组的元素，以空格分隔各个元素：");
    String input = scanner.nextLine();
    String[] elements = input.split(" ");
    int[] height = new int[elements.length];

    for (int i = 0; i < elements.length; i++) {
        height[i] = Integer.parseInt(elements[i]);
    }

    int result = maxArea(height);
    System.out.println("容器可以储存的最大水量是: " + result);

    scanner.close();
}

}
