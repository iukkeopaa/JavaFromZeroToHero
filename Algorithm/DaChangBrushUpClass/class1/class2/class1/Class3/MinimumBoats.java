package DaChangBrushUpClass.class1.class2.class1.Class3;

import java.util.Arrays;

//给定一个正数数组arr，代表若干人的体重，再给定一个正数limit，表示所有船共同拥有的载重量，每艘船最多坐两人，且不能超过载重
//想让所有的人同时过河，并且用最好的分配方法让船尽量少，返回最少的船数
public class MinimumBoats {
    public static int minBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int boats = 0;

        while (left <= right) {
            if (arr[left] + arr[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            boats++;
        }
        return boats;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 6;
        System.out.println("最少需要的船数: " + minBoats(arr, limit));
    }
}    