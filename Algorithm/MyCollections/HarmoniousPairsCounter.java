package MyCollections;

//小红认为一个数对(, y) 如果满足 | -y| =||-|y|，那么这个数对是和谐的。
//现在给定一个长度为 n 的数组 a，请你統计有多少对(i,j)(i < j)满足(ai,aj)是和谐的。
public class HarmoniousPairsCounter {
    public static int countHarmoniousPairs(int[] a) {
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        // 统计正数、负数和 0 的数量
        for (int num : a) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        // 计算满足条件的数对数量
        int positivePairs = positiveCount * (positiveCount - 1) / 2;
        int negativePairs = negativeCount * (negativeCount - 1) / 2;
        int zeroPairs = zeroCount * (zeroCount - 1) / 2;
        int crossZeroPairs = zeroCount * (positiveCount + negativeCount);

        return positivePairs + negativePairs + zeroPairs + crossZeroPairs;
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 3, -4};
        int result = countHarmoniousPairs(a);
        System.out.println("满足和谐条件的数对数量: " + result);
    }
}    