package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

public class FirstUniqueChar {
    public static char firstUniqChar(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String str = "abaccdeff";
        char result = firstUniqChar(str);
        System.out.println("第一个只出现一次的字符是: " + result);
    }
}    