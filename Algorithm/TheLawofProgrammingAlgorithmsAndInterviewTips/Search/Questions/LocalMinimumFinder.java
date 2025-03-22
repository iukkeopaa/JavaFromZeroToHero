package TheLawofProgrammingAlgorithmsAndInterviewTips.Search.Questions;

public class LocalMinimumFinder {
    public static int findLocalMinimum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5};
        int localMin = findLocalMinimum(arr);
        System.out.println("局部最小值是: " + localMin);
    }
}    