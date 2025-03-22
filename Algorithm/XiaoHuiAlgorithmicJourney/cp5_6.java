package XiaoHuiAlgorithmicJourney;

public class cp5_6 {
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) {
            return 0;
        }
        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        int[] minBucket = new int[bucketCount];
        int[] maxBucket = new int[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            minBucket[i] = Integer.MAX_VALUE;
            maxBucket[i] = Integer.MIN_VALUE;
        }
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize;
            minBucket[bucketIndex] = Math.min(minBucket[bucketIndex], num);
            maxBucket[bucketIndex] = Math.max(maxBucket[bucketIndex], num);
        }
        int maxGap = 0;
        int prevMax = maxBucket[0];
        for (int i = 1; i < bucketCount; i++) {
            if (minBucket[i] != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, minBucket[i] - prevMax);
                prevMax = maxBucket[i];
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println("排序后相邻元素的最大差值是: " + maximumGap(nums));
    }
}