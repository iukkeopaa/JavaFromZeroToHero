package MyCollections.FindSubtreeNodes.ArrayPermutation;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {
    public static List<int[]> permute(int[][] arrays) {
        List<int[]> result = new ArrayList<>();
        if (arrays == null || arrays.length == 0) {
            return result;
        }
        int[] current = new int[arrays.length];
        permuteHelper(arrays, 0, current, result);
        return result;
    }

    private static void permuteHelper(int[][] arrays, int index, int[] current, List<int[]> result) {
        if (index == arrays.length) {
            result.add(current.clone());
            return;
        }
        for (int num : arrays[index]) {
            current[index] = num;
            permuteHelper(arrays, index + 1, current, result);
        }
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<int[]> result = permute(arrays);
        for (int[] arr : result) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}    