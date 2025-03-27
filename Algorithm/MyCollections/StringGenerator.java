package MyCollections;

//С��������������Ⱦ�Ϊn���ַ��� S �� S?��������Сд��ĸ��
//����ͨ�� S �� S,����һ������Ϊ n ���ַ��� T��T �����ɹ�������:
//���ڵ�iλ���� S:= S2:����ΪS:�Ĵ�д��ʽ������T=max(Si,S2:)������ max(,y)��ʾr��y�ֵ�
//���нϴ��һ����
//����С����֪�����ɵ��ַ��� T��
public class StringGenerator {
    public static String generateString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("�����ַ������ȱ�����ͬ");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                result.append(Character.toUpperCase(c1));
            } else {
                result.append(c1 > c2? c1 : c2);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abce";
        String t = generateString(s1, s2);
        System.out.println(t);
    }
}