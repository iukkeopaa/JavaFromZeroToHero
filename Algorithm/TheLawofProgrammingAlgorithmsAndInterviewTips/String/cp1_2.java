package TheLawofProgrammingAlgorithmsAndInterviewTips.String;

public class cp1_2 {
    public static boolean StringContain(String a, String b) {
        // 用于记录长字符串 a 中出现的字符
        int hash = 0;
        // 遍历长字符串 a
        for (int i = 0; i < a.length(); i++) {
            // 通过位运算将对应字符的位置置为 1
            hash |= (1 << (a.charAt(i) - 'A'));
        }
        // 遍历短字符串 b
        for (int i = 0; i < b.length(); i++) {
            // 检查当前字符对应的位是否为 0
            if ((hash & (1 << (b.charAt(i) - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "ABCD";
        String b = "BAD";
        System.out.println(StringContain(a, b));
    }
}