package MyCollections;

import java.util.Scanner;

//С����Ϊһ���ַ����Ǻ��ַ������ҽ�������ַ���ȥ�غ������˳���������ֵ�������һ�����������ַ�����
//����:s = aabca��ȥ�غ�Ϊabc�������ֵ��򵥵�������
//����С����һ������Ϊn���ַ���t����������������ж��ٸ��ǿ��Ӵ��Ǻ��ַ�����
//ȥ��:ÿ���ַ�ֻ������һ�����ֵ�λ�á�
//�Ӵ�:�Ӵ���ָһ���ַ����е��������֡�
//��������
//��һ��һ������n(1 ��n�� 10��)����ʾ�ַ������ȡ�
//�ڶ���һ������Ϊn���ַ���t����֤����ֻ��Сд��ĸ,
//�������
//һ����������ʾt���ж��ٸ��Ӵ��Ǻ��ַ�����
public class GoodSubstringCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String t = scanner.nextLine();
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[26];
            StringBuilder unique = new StringBuilder();
            for (int j = i; j < n; j++) {
                char c = t.charAt(j);
                if (!visited[c - 'a']) {
                    visited[c - 'a'] = true;
                    unique.append(c);
                }
                if (isMonotonicIncreasing(unique.toString())) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isMonotonicIncreasing(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) <= s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}    