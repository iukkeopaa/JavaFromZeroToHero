package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

public class EvenlyDistribute01 {
    public static int minCuts(String s) {
        int n = s.length();
        // 统计字符串中 0 和 1 的总数
        int totalZeros = 0;
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                totalZeros++;
            } else {
                totalOnes++;
            }
        }
        // 每个人应得到的 0 和 1 的数量
        int targetZeros = totalZeros / 2;
        int targetOnes = totalOnes / 2;

        // 尝试不同的切分点
        for (int cuts = 0; cuts < n; cuts++) {
            // 生成所有可能的切分组合
            for (int mask = 0; mask < (1 << cuts); mask++) {
                int currentZeros = 0;
                int currentOnes = 0;
                int start = 0;
                for (int i = 0; i < cuts; i++) {
                    if ((mask & (1 << i)) != 0) {
                        String segment = s.substring(start, i + 1);
                        for (char c : segment.toCharArray()) {
                            if (c == '0') {
                                currentZeros++;
                            } else {
                                currentOnes++;
                            }
                        }
                        start = i + 1;
                    }
                }
                String lastSegment = s.substring(start);
                for (char c : lastSegment.toCharArray()) {
                    if (c == '0') {
                        currentZeros++;
                    } else {
                        currentOnes++;
                    }
                }
                if (currentZeros == targetZeros && currentOnes == targetOnes) {
                    return cuts;
                }
            }
        }
        return n - 1;
    }

    public static void main(String[] args) {
        String s = "010111";
        int result = minCuts(s);
        System.out.println("最少切分次数: " + result);
    }
}    