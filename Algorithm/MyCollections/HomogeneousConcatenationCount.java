package MyCollections;

import java.util.*;

//题目内容
//小红有一个长度为3的字符串s[1]。
//她希望在其基础上增加n -1个字符串，使得对于任意i€[2,n]都满足s|{0)= si- 1][2]，且每个字符串的长度以
//及所包含的字母种类和对应的数量都相同，我们称这个几个字符串构成同质接龙串。
//理有小红想知道在给定s[1]的基础上，构成的同质接龙串的共有多少种，当两种方案有一个位置的字符串不相同时，
//们则认为是不同的方案。由于结果可能很大，对109+7取模后再输出。
public class HomogeneousConcatenationCount {
    private static final int MOD = 1000000007;

    // 生成所有可能的字符串
    private static List<String> generatePossibleStrings(int[] charCount, int len) {
        List<String> result = new ArrayList<>();
        char[] chars = new char[len];
        generateStringsHelper(charCount, 0, chars, result);
        return result;
    }

    private static void generateStringsHelper(int[] charCount, int index, char[] chars, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                charCount[i]--;
                chars[index] = (char) ('a' + i);
                generateStringsHelper(charCount, index + 1, chars, result);
                charCount[i]++;
            }
        }
    }

    // 构建邻接矩阵
    private static int[][] buildAdjacencyMatrix(List<String> strings) {
        int n = strings.size();
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (strings.get(i).charAt(strings.get(i).length() - 1) == strings.get(j).charAt(0)) {
                    adjMatrix[i][j] = 1;
                }
            }
        }
        return adjMatrix;
    }

    // 查找字符串在列表中的索引
    private static int findIndex(List<String> strings, String target) {
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int countHomogeneousConcatenation(String s1, int n) {
        int len = s1.length();
        // 统计 s1 中每个字符的数量
        int[] charCount = new int[26];
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }

        // 生成所有可能的字符串
        List<String> possibleStrings = generatePossibleStrings(charCount, len);

        // 构建邻接矩阵
        int[][] adjMatrix = buildAdjacencyMatrix(possibleStrings);

        // 动态规划数组
        int[][] dp = new int[n + 1][possibleStrings.size()];
        int startIndex = findIndex(possibleStrings, s1);
        dp[1][startIndex] = 1;

        // 动态规划计算方案数
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < possibleStrings.size(); j++) {
                for (int k = 0; k < possibleStrings.size(); k++) {
                    if (adjMatrix[k][j] == 1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                    }
                }
            }
        }

        // 计算最终结果
        int result = 0;
        for (int i = 0; i < possibleStrings.size(); i++) {
            result = (result + dp[n][i]) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        int n = 3;
        System.out.println(countHomogeneousConcatenation(s1, n));
    }
}    