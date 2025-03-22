package CrackingTheCodingInterview.ch11;

public class MergeSortedArrays {
    public static void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k] = A[i];
                i--;
            } else {
                A[k] = B[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            A[k] = B[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        int[] B = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge(A, m, B, n);
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}    