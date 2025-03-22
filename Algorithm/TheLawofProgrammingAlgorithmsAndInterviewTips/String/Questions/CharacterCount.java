package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
    public static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    public static void main(String[] args) {
        String testString = "HelloWorld";
        Map<Character, Integer> result = countCharacters(testString);
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}    