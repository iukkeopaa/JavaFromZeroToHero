package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class ArrayMerge {
    public static void merge(int[] A, int mid) {
        int n = A.length;
        int i = 0;
        int j = mid;
        while (i < mid && j < n) {
            if (A[i] <= A[j]) {
                i++;
            } else {
                int temp = A[j];
                for (int k = j; k > i; k--) {
                    A[k] = A[k - 1];
                }
                A[i] = temp;
                i++;
                mid++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 2, 4, 6};
        int mid = 3;
        merge(A, mid);
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}    