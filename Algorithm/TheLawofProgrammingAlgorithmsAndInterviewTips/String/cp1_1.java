package TheLawofProgrammingAlgorithmsAndInterviewTips.String;

public class cp1_1 {
    public static String rotateString(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0 || n >= s.length()) {
            return s;
        }
        // 提取前 n 个字符
        String firstPart = s.substring(0, n);
        // 提取剩余的字符
        String secondPart = s.substring(n);
        // 拼接字符串
        return secondPart + firstPart;
    }

    public static void main(String[] args) {
        String s = "abcdef";
        int n = 3;
        String result = rotateString(s, n);
        System.out.println(result);
    }
}

