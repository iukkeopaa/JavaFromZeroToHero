package CrackingTheCodingInterview.ch9;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {
    private static final int N = 8;
    private static int solutions = 0;

    public static void main(String[] args) {
        List<int[]> result = solveNQueens(N);
        for (int[] solution : result) {
            printBoard(solution);
            System.out.println();
        }
        System.out.println("Total solutions: " + solutions);
    }

    public static List<int[]> solveNQueens(int n) {
        List<int[]> result = new ArrayList<>();
        int[] queens = new int[n];
        backtrack(result, queens, 0);
        return result;
    }

    private static void backtrack(List<int[]> result, int[] queens, int row) {
        if (row == N) {
            result.add(queens.clone());
            solutions++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                backtrack(result, queens, row + 1);
            }
        }
    }

    private static boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(int[] queens) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}    