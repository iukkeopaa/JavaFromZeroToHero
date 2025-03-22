package CrackingTheCodingInterview.ch9;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static List<String> getPermutations(String str) {
        List<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }
        permute(str.toCharArray(), 0, result);
        return result;
    }

    private static void permute(char[] arr, int start, List<String> result) {
        if (start == arr.length) {
            result.add(new String(arr));
        } else {
            for (int i = start; i < arr.length; i++) {
                swap(arr, start, i);
                permute(arr, start + 1, result);
                swap(arr, start, i);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String input = "abc";
        List<String> permutations = getPermutations(input);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}    