package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.ArrayList;
import java.util.List;

public class FindCommonElements {
    public static List<Integer> findCommonElements(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        if (arrays == null || arrays.length == 0) {
            return result;
        }
        int[] firstArray = arrays[0];
        for (int num : firstArray) {
            boolean isCommon = true;
            for (int i = 1; i < arrays.length; i++) {
                if (!binarySearch(arrays[i], num)) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon && (result.isEmpty() || result.get(result.size() - 1) != num)) {
                result.add(num);
            }
        }
        return result;
    }

    private static boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7}
        };
        List<Integer> commonElements = findCommonElements(arrays);
        System.out.println(commonElements);
    }
}    