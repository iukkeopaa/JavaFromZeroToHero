package MyCollections;

import java.util.HashSet;
import java.util.Set;

//С����һ������Ϊn���ַ���s������֪������ַ����ж��ٸ����ȴ���1���Ӵ��ǿɾ���ġ�
//�ɾ������˼��:һ���ַ����ǻ��Ĵ���������ÿ���ַ����д�ֱ�Գ��ᡣ
//[���Ĵ�]һ���ַ������������Ĵ������ҽ�������ַ����������Ҷ��ʹ������������ͬ�ġ�
//�д�ֱ�Գ���Ĵ�д��ĸ:A��HT��M,O��T"U��V'W'X'Y
public class MirrorSubstringCounter {
    // �洢�д�ֱ�Գ�����ַ�
    private static final Set<Character> SYMMETRIC_CHARS = new HashSet<>();
    static {
        String symmetric = "AHIMOTUVWXY";
        for (char c : symmetric.toCharArray()) {
            SYMMETRIC_CHARS.add(c);
        }
    }

    public static int countMirrorSubstrings(String s) {
        int n = s.length();
        int count = 0;
        // ����ÿ�����ܵ�����λ��
        for (int i = 0; i < n; i++) {
            // ����������ȵĻ��Ĵ�
            count += expandAroundCenter(s, i, i);
            // ���ż�����ȵĻ��Ĵ�
            count += expandAroundCenter(s, i, i + 1);
        }
        return count;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
                && SYMMETRIC_CHARS.contains(s.charAt(left))) {
            if (right - left + 1 > 1) {
                count++;
            }
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "AHA";
        System.out.println(countMirrorSubstrings(s));
    }
}    