package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

public class StringSpaceCompression {
    public static void main(String[] args) {
        String input = "abc efg hij";
        String result = processString(input);
        System.out.println(result);
    }

    public static String processString(String input) {
        // 去除多余空格
        String compressed = input.replaceAll("\\s+", " ").trim();
        String[] words = compressed.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String reversed = new StringBuilder(words[i]).reverse().toString();
            result.append(reversed);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}    