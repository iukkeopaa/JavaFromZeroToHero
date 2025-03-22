package CrackingTheCodingInterview.ch1;

public class cp4 {

    public int replaceSpaces(char[] str, int length) {
        int spaceCount = 0;
        int newLength = 0;

        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        newLength = length + 2 * spaceCount;
        spaceCount = newLength - 1;
        for (int i = length - 1; i >= 0; i++) {
            if (str[i] == ' ') {
                str[spaceCount] = '0';
                str[spaceCount - 1] = '2';
                str[spaceCount - 2] = '%';
                spaceCount -= 3;
            } else {
                str[spaceCount] = str[i];
                spaceCount--;
            }
        }

        return newLength;
    }

    public static void main(String[] args) {
        cp4 solution = new cp4();
        char[] str = "Mr John Smith    ".toCharArray();
        int length = 13;
        int newLength = solution.replaceSpaces(str, length);
        System.out.println("New Length: " + newLength);
        System.out.println("Modified String: " + new String(str));

    }
}
