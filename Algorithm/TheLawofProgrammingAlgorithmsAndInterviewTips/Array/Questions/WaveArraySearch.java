package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class WaveArraySearch {
    public static int search(int[] arr, int target) {
        int n = arr.length;
        int pivot = findPivot(arr, 0, n - 1);

        // 如果没有转折点，整个数组是递增的
        if (pivot == -1) {
            return binarySearch(arr, 0, n - 1, target);
        }

        // 先在前半部分查找
        if (arr[0] <= target && target <= arr[pivot]) {
            return binarySearch(arr, 0, pivot, target);
        }
        // 在后半部分查找
        return binarySearch(arr, pivot + 1, n - 1, target);
    }

    // 找到数组中的转折点
    private static int findPivot(int[] arr, int low, int high) {
        if (high < low) {
            return -1;
        }
        if (high == low) {
            return low;
        }
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }
        if (arr[low] >= arr[mid]) {
            return findPivot(arr, low, mid - 1);
        }
        return findPivot(arr, mid + 1, high);
    }

    // 二分查找
    private static int binarySearch(int[] arr, int low, int high, int target) {
        if (high < low) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (target > arr[mid]) {
            return binarySearch(arr, mid + 1, high, target);
        }
        return binarySearch(arr, low, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8, 9, 4, 8, 11, 18, 19, 100};
        int target = 8;
        int result = search(arr, target);
        if (result != -1) {
            System.out.println("元素 " + target + " 在数组中的索引是: " + result);
        } else {
            System.out.println("元素 " + target + " 不在数组中。");
        }
    }
}