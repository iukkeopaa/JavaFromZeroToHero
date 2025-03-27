package Hash.Q1;

import java.util.HashMap;
import java.util.Scanner;

import static Hash.Q1.p1.twoSum;


/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/26 上午11:21
 */
public class p1_v {

    public static int[] TwoSum(int[] nums, int target){
        //先定义一个HashMap来记录访问过的元素
        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i=0;i<nums.length;i++){

            int chazhi = target - nums[i];

            if(map.containsKey(chazhi)){
                return new int[]{map.get(chazhi),i};
            }

            map.put(chazhi,i);

        }

        return new int[]{};
    }


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
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
