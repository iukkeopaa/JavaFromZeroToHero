package MyCollections;

import java.util.Arrays;

//��������һλ԰�����ʦ������ͷ��һЩľ�壬ÿ��ľ��ĳ��Ȳ�ͬ������Ҫ����Щľ��������һ�������εĻ�̳Χ
//�����㲻���и��κ�һ��ľ�壬������԰���������һ�𣬶���ÿ��ľ�����ʹ��һ�Ρ������������Щľ��ƴ��һ��
//�����ε�Χ�����򷵻� true ;���򷵻� false��
public class SquareFence {
    public static boolean canFormSquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int sideLength = sum / 4;
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, 0, 0, sideLength, 0);
    }

    private static boolean backtrack(int[] nums, boolean[] used, int currentSide, int index, int sideLength, int sidesDone) {
        if (sidesDone == 3) {
            return true;
        }
        if (currentSide == sideLength) {
            return backtrack(nums, used, 0, 0, sideLength, sidesDone + 1);
        }
        for (int i = index; i < nums.length; i++) {
            if (!used[i] && currentSide + nums[i] <= sideLength) {
                used[i] = true;
                if (backtrack(nums, used, currentSide + nums[i], i + 1, sideLength, sidesDone)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] boards = {1, 1, 2, 2, 2};
        System.out.println(canFormSquare(boards));
    }
}