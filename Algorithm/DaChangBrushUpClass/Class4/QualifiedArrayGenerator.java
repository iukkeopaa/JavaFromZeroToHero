package DaChangBrushUpClass.Class4;

import java.util.Arrays;

//生成长度为size的达标数组，什么叫达标？对于任意的i<k<j，满足[i]+[j]!=[k]*2。给定一个正数size，返回长度为size的达标数组
//思路：递归，每次生成一半的达标数组，然后将这个数组中的每个数乘以2-1和乘以2，交替放入结果数组中
//举例：size=5
//1. 生成size=3的达标数组：[1,3,2]
//2. 将这个数组中的每个数乘以2-1和乘以2，交替放入结果数组中：[1,3,2,2,4,6]
//3. 返回结果数组：[1,3,2,2,4,6]


public class QualifiedArrayGenerator {
    public static int[] generateArray(int size) {
        if (size == 1) {
            return new int[]{1};
        }
        int[] base = generateArray(size / 2 + size % 2);
        int[] result = new int[size];
        int index = 0;
        for (int num : base) {
            result[index++] = num * 2 - 1;
        }
        for (int num : base) {
            if (index < size) {
                result[index++] = num * 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int size = 5;
        int[] array = generateArray(size);
        System.out.println(Arrays.toString(array));
    }
}    