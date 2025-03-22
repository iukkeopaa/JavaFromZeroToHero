package XiaoHuiAlgorithmicJourney;

import java.util.Arrays;

public class cp5_8 {
    public static int nextPermutation(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = digits.length - 1;
            while (j >= 0 && digits[j] <= digits[i]) {
                j--;
            }
            swap(digits, i, j);
        }
        reverse(digits, i + 1);
        try {
            return Integer.parseInt(new String(digits));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private static void reverse(char[] digits, int start) {
        int i = start, j = digits.length - 1;
        while (i < j) {
            swap(digits, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int num = 123;
        int next = nextPermutation(num);
        System.out.println("The next permutation of " + num + " is: " + next);
    }
}