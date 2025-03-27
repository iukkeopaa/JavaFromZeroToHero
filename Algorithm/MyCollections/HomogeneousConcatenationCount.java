package MyCollections;

import java.util.*;

//��Ŀ����
//С����һ������Ϊ3���ַ���s[1]��
//��ϣ���������������n -1���ַ�����ʹ�ö�������i��[2,n]������s|{0)= si- 1][2]����ÿ���ַ����ĳ�����
//������������ĸ����Ͷ�Ӧ����������ͬ�����ǳ���������ַ�������ͬ�ʽ�������
//����С����֪���ڸ���s[1]�Ļ����ϣ����ɵ�ͬ�ʽ������Ĺ��ж����֣������ַ�����һ��λ�õ��ַ�������ͬʱ��
//������Ϊ�ǲ�ͬ�ķ��������ڽ�����ܴܺ󣬶�109+7ȡģ���������
public class HomogeneousConcatenationCount {
    private static final int MOD = 1000000007;

    // �������п��ܵ��ַ���
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

    // �����ڽӾ���
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

    // �����ַ������б��е�����
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
        // ͳ�� s1 ��ÿ���ַ�������
        int[] charCount = new int[26];
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }

        // �������п��ܵ��ַ���
        List<String> possibleStrings = generatePossibleStrings(charCount, len);

        // �����ڽӾ���
        int[][] adjMatrix = buildAdjacencyMatrix(possibleStrings);

        // ��̬�滮����
        int[][] dp = new int[n + 1][possibleStrings.size()];
        int startIndex = findIndex(possibleStrings, s1);
        dp[1][startIndex] = 1;

        // ��̬�滮���㷽����
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < possibleStrings.size(); j++) {
                for (int k = 0; k < possibleStrings.size(); k++) {
                    if (adjMatrix[k][j] == 1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                    }
                }
            }
        }

        // �������ս��
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