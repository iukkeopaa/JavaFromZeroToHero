package TheLawofProgrammingAlgorithmsAndInterviewTips.Search.Questions;

public class RotatedArraySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int target1 = 5;
        System.out.println(search(nums1, target1));

        int[] nums2 = {8, 9, 1, 2, 3, 4, 5};
        int target2 = 7;
        System.out.println(search(nums2, target2));
    }
}    