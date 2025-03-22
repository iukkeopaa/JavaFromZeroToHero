package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class AdjacentDifference {
    public static double findMaxDifference(double[] V) {
        int n = V.length;
        if (n < 2) {
            return 0;
        }
        double minVal = Double.MAX_VALUE;
        double maxVal = Double.MIN_VALUE;
        // 找出数组中的最小值和最大值
        for (double num : V) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }
        if (minVal == maxVal) {
            return 0;
        }
        // 桶的大小
        double bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        // 桶的数量
        int bucketNum = (int) ((maxVal - minVal) / bucketSize) + 1;
        // 每个桶的最小值和最大值
        double[] minBucket = new double[bucketNum];
        double[] maxBucket = new double[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            minBucket[i] = Double.MAX_VALUE;
            maxBucket[i] = Double.MIN_VALUE;
        }
        // 将每个数放入对应的桶中，并更新桶的最小值和最大值
        for (double num : V) {
            int bucketIndex = (int) ((num - minVal) / bucketSize);
            minBucket[bucketIndex] = Math.min(minBucket[bucketIndex], num);
            maxBucket[bucketIndex] = Math.max(maxBucket[bucketIndex], num);
        }
        double maxDiff = 0;
        double prevMax = maxBucket[0];
        // 遍历桶，计算相邻非空桶的最大最小值的差
        for (int i = 1; i < bucketNum; i++) {
            if (minBucket[i] != Double.MAX_VALUE) {
                maxDiff = Math.max(maxDiff, minBucket[i] - prevMax);
                prevMax = maxBucket[i];
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        double[] V = {1.2, 3.4, 2.1, 5.6, 4.3};
        double maxDifference = findMaxDifference(V);
        System.out.println("相邻实数差的最大值: " + maxDifference);
    }
}    