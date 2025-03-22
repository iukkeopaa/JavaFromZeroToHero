package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDuplicateRemoval {
    public static int[] removeDuplicates(int[] arr) {
        List<Integer> uniqueList = new ArrayList<>();
        for (int num : arr) {
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }
        int[] result = new int[uniqueList.size()];
        for (int i = 0; i < uniqueList.size(); i++) {
            result[i] = uniqueList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 2, -1, 999, 3, 999, 88};
        int[] uniqueArr = removeDuplicates(arr);
        System.out.println(Arrays.toString(uniqueArr));
    }
}    