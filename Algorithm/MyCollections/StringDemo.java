package MyCollections;

import java.util.Scanner;

//С���õ���һ�����ɴ�д��ĸ��Сд��ĸ��ɵ��ַ���������֪�����ڲ����Ǵ�Сд������£��ж��ٶ����ڵ���ĸ��ȣ�
//�������ӣ�
//"aABbbC"
//������ӣ�
//3
public class StringDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i - 1))) {
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}