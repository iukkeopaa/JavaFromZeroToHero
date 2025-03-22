package CrackingTheCodingInterview.ch1;

public class cp5 {
    public static String compressString(String s) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(s.charAt(i)).append(count);
                count = 1;
            }
        }
        String compressedStr = compressed.toString();
        return compressedStr.length() < s.length() ? compressedStr : s;
    }

    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println(compressString(input));
    }
}
