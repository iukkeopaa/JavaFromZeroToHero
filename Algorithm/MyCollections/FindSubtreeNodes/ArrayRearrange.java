package MyCollections.FindSubtreeNodes;

//一个数组，让里面的数变成：奇数下标都是奇数或者偶数下标都是偶数。时间复
//杂度 O(N),空间复杂度 O(1)。
public class ArrayRearrange {
    public static int[] rearrangeArray(int[] nums) {
        int even = 0;
        int odd = 1;
        int n = nums.length;
        while (even < n && odd < n) {
            if (nums[even] % 2 == 0) {
                even += 2;
            } else if (nums[odd] % 2 == 1) {
                odd += 2;
            } else {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even += 2;
                odd += 2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        int[] result = rearrangeArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}    