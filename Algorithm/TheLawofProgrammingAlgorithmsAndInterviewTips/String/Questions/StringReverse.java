package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

public class StringReverse {
    public static String reverseString(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] charArray = input.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String test = "July";
        String reversed = reverseString(test);
        System.out.println(reversed);
    }
}    