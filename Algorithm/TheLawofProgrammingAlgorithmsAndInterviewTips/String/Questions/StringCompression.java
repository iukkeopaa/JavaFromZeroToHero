package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

import java.util.Scanner;

public class StringCompression {
    public static String compressString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                if (count > 1) {
                    compressed.append(count);
                }
                compressed.append(input.charAt(i));
                count = 1;
            }
        }
        return compressed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要压缩的字符串:");
        String input = scanner.nextLine();
        String compressedString = compressString(input);
        System.out.println("压缩后的字符串是: " + compressedString);
        scanner.close();
    }
}    