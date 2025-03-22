package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class MedianOfTwoArrays {
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int totalLength = m + n;
        int i = 0, j = 0;
        int prev = 0, current = 0;

        for (int k = 0; k <= totalLength / 2; k++) {
            prev = current;
            if (i < m && (j >= n || A[i] < B[j])) {
                current = A[i++];
            } else {
                current = B[j++];
            }
        }

        if (totalLength % 2 == 1) {
            return current;
        } else {
            return (prev + current) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3};
        int[] B = {2};
        System.out.println("中位数是: " + findMedianSortedArrays(A, B));
    }
}    