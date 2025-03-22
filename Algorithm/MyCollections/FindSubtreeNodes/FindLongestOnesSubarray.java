package MyCollections.FindSubtreeNodes;


//一个一维数组，全是 0 和 1，找最长的 1 子数组。
public class FindLongestOnesSubarray {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }

        // 处理数组末尾是 1 的情况
        maxCount = Math.max(maxCount, currentCount);
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int result = findMaxConsecutiveOnes(nums);
        System.out.println("最长的全 1 子数组的长度是: " + result);
    }
}    