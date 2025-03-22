package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.ArrayList;
import java.util.List;

public class EggInBaskets {
    public static List<List<Integer>> findSolutions(int n, int m) {
        List<List<Integer>> result = new ArrayList<>();
        int[] current = new int[m];
        // 第一个篮子至少放 1 个鸡蛋
        current[0] = 1;
        backtrack(n, m, 1, n - 1, current, result);
        return result;
    }

    private static void backtrack(int n, int m, int index, int remaining, int[] current, List<List<Integer>> result) {
        if (index == m) {
            if (remaining == 0 && canRepresentAll(n, current)) {
                List<Integer> solution = new ArrayList<>();
                for (int num : current) {
                    solution.add(num);
                }
                result.add(solution);
            }
            return;
        }
        for (int i = current[index - 1]; i <= remaining - (m - index - 1); i++) {
            current[index] = i;
            backtrack(n, m, index + 1, remaining - i, current, result);
        }
    }

    private static boolean canRepresentAll(int n, int[] current) {
        boolean[] canRepresent = new boolean[n + 1];
        canRepresent[0] = true;
        for (int num : current) {
            for (int j = n; j >= num; j--) {
                if (canRepresent[j - num]) {
                    canRepresent[j] = true;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!canRepresent[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 9;
        int m = 5;
        List<List<Integer>> solutions = findSolutions(n, m);
        for (List<Integer> solution : solutions) {
            for (int num : solution) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}    