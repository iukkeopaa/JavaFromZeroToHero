package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

public class RemoveSpecificChars {
    public static String removeChars(String original, String pattern) {
        boolean[] isToRemove = new boolean[256];
        for (char c : pattern.toCharArray()) {
            isToRemove[c] = true;
        }
        StringBuilder result = new StringBuilder();
        for (char c : original.toCharArray()) {
            if (isToRemove[c]) {
                result.append(' ');
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String original = "They are students.";
        String pattern = "aeiou";
        String result = removeChars(original, pattern);
        System.out.println(result);
    }
}    