package MyCollections.FindSubtreeNodes.SubsequenceCount;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceCount {
    public static long countSubsequences(List<int[]> sequences) {
        long totalSubsequences = 1;
        for (int[] sequence : sequences) {
            int start = sequence[0];
            int end = sequence[1];
            int length = end - start + 1;
            // 对于长度为 length 的序列，其非空子序列的数量为 2^length - 1
            // 这里加上 1 是为了包含空序列
            totalSubsequences *= (long) Math.pow(2, length);
        }
        // 减去所有序列都为空的情况
        return totalSubsequences - 1;
    }

    public static void main(String[] args) {
        List<int[]> sequences = new ArrayList<>();
        sequences.add(new int[]{2, 5});
        sequences.add(new int[]{1, 3});

        long result = countSubsequences(sequences);
        System.out.println("可能的子序列总数为: " + result);
    }
}    