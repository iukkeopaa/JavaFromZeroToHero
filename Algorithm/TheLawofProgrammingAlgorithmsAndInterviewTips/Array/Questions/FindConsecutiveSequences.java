package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.ArrayList;
import java.util.List;

public class FindConsecutiveSequences {
    public static List<List<Integer>> findSequences(int n) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 1;
        int right = 2;
        int sum = left + right;
        while (left < right) {
            if (sum == n) {
                List<Integer> sequence = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    sequence.add(i);
                }
                result.add(sequence);
                sum -= left;
                left++;
            } else if (sum < n) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        List<List<Integer>> sequences = findSequences(n);
        for (List<Integer> sequence : sequences) {
            System.out.print(sequence.get(0) + "～" + sequence.get(sequence.size() - 1));
            System.out.println();
        }
    }
}    