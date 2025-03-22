package TheLawofProgrammingAlgorithmsAndInterviewTips.Dp.Questions;

import java.util.*;

public class SubsequenceCount {
    public static int countDistinctSubsequences(int[] a) {
        Set<String> subsequences = new HashSet<>();
        int n = a.length;
        // 2^n 种可能的子序列组合
        for (int i = 1; i < (1 << n); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sb.append(a[j]).append(",");
                }
            }
            if (sb.length() > 0) {
                // 去掉最后一个逗号
                sb.deleteCharAt(sb.length() - 1);
            }
            subsequences.add(sb.toString());
        }
        return subsequences.size();
    }

    public static void main(String[] args) {
        int[] a = {4, 13, 14, 1, 2, 3};
        int result = countDistinctSubsequences(a);
        System.out.println("不同子序列的数量: " + result);
    }
}    