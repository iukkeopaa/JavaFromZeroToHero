

package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

public class CharacterMovement {
    public static String moveAsterisksToLeft(String s) {
        int n = s.length();
        char[] result = new char[n];
        int letterIndex = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '*') {
                result[letterIndex] = s.charAt(i);
                letterIndex--;
            }
        }
        while (letterIndex >= 0) {
            result[letterIndex] = '*';
            letterIndex--;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String input = "a*b*c*d";
        String output = moveAsterisksToLeft(input);
        System.out.println(output);
    }
}    