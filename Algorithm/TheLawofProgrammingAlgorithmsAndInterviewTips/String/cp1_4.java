package TheLawofProgrammingAlgorithmsAndInterviewTips.String;

public class cp1_4 {
    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        int result = 0;

        // 处理符号
        if (str.charAt(0) == '-') {
            sign = -1;
            index = 1;
        } else if (str.charAt(0) == '+') {
            index = 1;
        }

        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                result = result * 10 + (c - '0');
            } else {
                return 0;
            }
        }
        return sign * result;
    }

    public static void main(String[] args) {
        String input = "123";
        int output = strToInt(input);
        System.out.println(output);
    }
}