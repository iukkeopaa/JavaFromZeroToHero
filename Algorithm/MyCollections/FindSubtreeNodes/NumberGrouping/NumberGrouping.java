package MyCollections.FindSubtreeNodes.NumberGrouping;

import java.util.ArrayList;
import java.util.List;

public class NumberGrouping {
    public static List<List<Integer>> groupNumbers(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < input.length; i += 3) {
            int endIndex = Math.min(i + 3, input.length);
            List<Integer> group = new ArrayList<>();
            for (int j = i; j < endIndex; j++) {
                group.add(input[j]);
            }
            result.add(group);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
        List<List<Integer>> grouped = groupNumbers(input);
        System.out.println(grouped);
    }
}    