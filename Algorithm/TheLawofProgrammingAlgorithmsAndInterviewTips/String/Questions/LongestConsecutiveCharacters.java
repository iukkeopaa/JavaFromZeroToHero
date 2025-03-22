package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

public class LongestConsecutiveCharacters {
    public static int longestConsecutive(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return helper(s, 0, 1, 1);
    }

    private static int helper(String s, int index, int currentLength, int maxLength) {
        if (index == s.length() - 1) {
            return Math.max(currentLength, maxLength);
        }
        if (s.charAt(index) == s.charAt(index + 1)) {
            return helper(s, index + 1, currentLength + 1, maxLength);
        } else {
            maxLength = Math.max(currentLength, maxLength);
            return helper(s, index + 1, 1, maxLength);
        }
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive("aaaabbcc")); 
        System.out.println(longestConsecutive("aabb")); 
        System.out.println(longestConsecutive("ab")); 
    }
}    