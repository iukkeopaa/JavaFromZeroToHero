package MyCollections;

//����һ���ַ���str������ַ���str�е���������Ӵ�
//�������ӣ�
//abcd12345ed125ss123058789
//������ӣ�
//123058789
public class LongestNumericSubstring {
    public static String findLongestNumericSubstring(String str) {
        String longest = "";
        int start = 0;
        while (start < str.length()) {
            if (Character.isDigit(str.charAt(start))) {
                int end = start;
                while (end < str.length() && Character.isDigit(str.charAt(end))) {
                    end++;
                }
                String current = str.substring(start, end);
                if (current.length() > longest.length()) {
                    longest = current;
                }
                start = end;
            } else {
                start++;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String str = "abc12345def67890";
        String result = findLongestNumericSubstring(str);
        System.out.println("��������Ӵ���: " + result);
    }
}    