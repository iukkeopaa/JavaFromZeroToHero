package MyCollections.FindSubtreeNodes.ArrayMagicOperation;

import java.util.ArrayList;
import java.util.List;

public class version1 {
    private static int minAbsValue = Integer.MAX_VALUE;
    private static List<String> bestOperations = new ArrayList<>();

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        List<String> operations = new ArrayList<>();
        dfs(array, 0, 0, operations);
        System.out.println("最小魔法值的绝对值: " + minAbsValue);
        System.out.println("对应的操作: " + String.join(" ", bestOperations));
    }

    private static void dfs(int[] array, int index, int magicValue, List<String> operations) {
        if (index == array.length) {
            int absValue = Math.abs(magicValue);
            if (absValue < minAbsValue) {
                minAbsValue = absValue;
                bestOperations = new ArrayList<>(operations);
            }
            return;
        }

        // 加当前数
        operations.add("UP");
        dfs(array, index + 1, magicValue + array[index], operations);
        operations.remove(operations.size() - 1);

        // 减当前数
        operations.add("DOWN");
        dfs(array, index + 1, magicValue - array[index], operations);
        operations.remove(operations.size() - 1);
    }
}