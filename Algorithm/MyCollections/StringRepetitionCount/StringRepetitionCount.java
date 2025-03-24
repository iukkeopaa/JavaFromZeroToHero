package MyCollections.FindSubtreeNodes.StringRepetitionCount;

public class StringRepetitionCount {
    public static int countRepetitions(String input, int k) {
        if (input == null || input.length() == 0 || k <= 0 || k > input.length()) {
            return 0;
        }
        String pattern = input.substring(0, k);
        int count = 0;
        int index = 0;
        while (index + k <= input.length()) {
            String currentSubstring = input.substring(index, index + k);
            if (currentSubstring.equals(pattern)) {
                count++;
                index += k;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "ABCDABCDABCD";
        int k = 4;
        int result = countRepetitions(input, k);
        System.out.println("前 " + k + " 个字的顺序重复了 " + result + " 次。");
    }
}    