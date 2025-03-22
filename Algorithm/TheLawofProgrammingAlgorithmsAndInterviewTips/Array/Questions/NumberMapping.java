package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.Arrays;

public class NumberMapping {
    public static int[] findMapping(int[] upperRow) {
        int n = upperRow.length;
        int[] lowerRow = new int[n];
        // 先初始化为 0
        Arrays.fill(lowerRow, 0);

        boolean isStable = false;
        while (!isStable) {
            isStable = true;
            int[] newLowerRow = new int[n];
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (lowerRow[j] == upperRow[i]) {
                        count++;
                    }
                }
                newLowerRow[i] = count;
                if (newLowerRow[i] != lowerRow[i]) {
                    isStable = false;
                }
            }
            // 更新下排数组
            System.arraycopy(newLowerRow, 0, lowerRow, 0, n);
        }
        return lowerRow;
    }

    public static void main(String[] args) {
        int[] upperRow = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] lowerRow = findMapping(upperRow);
        System.out.println(Arrays.toString(lowerRow));
    }
}    