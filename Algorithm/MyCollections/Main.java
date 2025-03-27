package MyCollections;

import java.util.Scanner;

//��Ŀ����
//С����һ�����ܵ��ַ���s��������֮��õ������ļ��ܷ�ʽ�����Խ⿪����!
//��ʼʱ�������ַ���tΪ��,����֮��,����һ����¼λ�Ƶ�����pΪ0�����ζ�ÿһ��i = 1,2,��,s
//�������²���(���ж������ַ���s�ĳ���)
//�����s�ĵ�i���ַ�Ϊ���֣�����Ҫ��p�޸ģ������:
//��p =0����p��Ϊ(��p��> ?);
//��p ��0����p�е�����ȫ�����λ�ƶ�һλ����󽫿ճ����ĸ�λ����(��p �� 10p+?)
//���s�ĵ�i���ַ���Ϊ���֣�����Ҫ�Ƚ��ַ�������pλ(��t,t..t,tp+1..:�� tp+1...t tt...t,),���p����
//��Ϊ0���ٶ�t�޸ģ������:
//���ַ�ΪR����ת�ַ���t
//���ַ���ΪR����ֱ�ӽ�����ַ���ӵ��ַ���t�Ľ�β;
//����ֱ�����������ɺ���ַ���t��
//��������
//ÿ�������ļ�����������������ݡ���һ������һ������T(1 < T < 10)������������,ÿ�����������������:
//��һ��������һ������Ϊ|s|(1 < |8| < 103),���ɴ�Сд��ĸ�����ֻ�Ϲ��ɵ��ַ���s����С���ļ��ܴ�,
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < T; i++) {
            String s = scanner.nextLine();
            System.out.println(decrypt(s));
        }
        scanner.close();
    }

    public static String decrypt(String s) {
        StringBuilder t = new StringBuilder();
        int p = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (p == 0) {
                    p = digit;
                } else {
                    p = 10 * p + digit;
                }
            } else {
                if (p > 0) {
                    int len = t.length();
                    p = p % len;
                    String left = t.substring(0, p);
                    String right = t.substring(p);
                    t = new StringBuilder(right + left);
                }
                p = 0;
                if (c == 'R') {
                    t.reverse();
                } else {
                    t.append(c);
                }
            }
        }
        return t.toString();
    }
}    