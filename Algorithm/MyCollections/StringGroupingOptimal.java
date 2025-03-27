package MyCollections;

import java.util.Scanner;

//��Ŀ����
//��С���� n ������Ϊ m �ҽ���Сд��ĸ��ɵ��ַ�����
//���������ַ��� p,q �Ĳ���ֵΪ������[p:�� q]�����б��ʽ�е�����Ϊ����ɭ���ţ����ʽ����ʱΪ1������Ϊ0��
//�������ַ����Ĳ���ֵС�ڵ���k����ô�����ַ�������һ���š�
//�������������С�μ����ܷ��� n���ַ�����Ϊһ���������ţ����������"YES�������������NO�����������Ҫɾ
//�����ٸ��ַ�����
//��������
//��һ��һ������ T(1 < T < 100)����ʾ���������ļ�������������
//����ÿһ�����ݸ�ʽΪ:
//��һ����������n,m,k(1��n��500,1��k��m��500)
//������ �� �У�ÿ��һ������Ϊm ���ַ������������Сд��ĸ��ɡ�
//���������ļ���֤��n < 500��
public class StringGroupingOptimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // ��ȡ��������������

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt(); // �ַ���������
            int m = scanner.nextInt(); // �ַ����ĳ���
            int k = scanner.nextInt(); // ����ֵ��ֵ
            scanner.nextLine(); // ���ĵ� nextInt() ��Ļ��з�

            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.nextLine();
            }

            boolean canGroup = true;
            String firstString = strings[0];

            // ֻ��ÿ���ַ����͵�һ���ַ����Ƚ�
            for (int i = 1; i < n; i++) {
                int diff = calculateDifference(firstString, strings[i]);
                if (diff > k) {
                    canGroup = false;
                    break;
                }
            }

            if (canGroup) {
                System.out.println("YES");
            } else {
                System.out.println("NO " + (n - 1));
            }
        }
        scanner.close();
    }

    // ���������ַ����Ĳ���ֵ
    private static int calculateDifference(String p, String q) {
        int diff = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != q.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}    