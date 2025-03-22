package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.ArrayList;
import java.util.List;

public class SubstringSumMod3 {
    public static List<String> findSubstrings(String str) {
        List<String> result = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = str.substring(i, j + 1);
                int sum = 0;
                for (char c : sub.toCharArray()) {
                    sum += Character.getNumericValue(c);
                }
                if (sum % 3 == 0) {
                    result.add(sub);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "012345";
        List<String> substrings = findSubstrings(str);
        for (String sub : substrings) {
            System.out.println(sub);
        }
    }
}    