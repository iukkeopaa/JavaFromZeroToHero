package CrackingTheCodingInterview.ch1;

public class cp2 {
    public String reverse(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = chars[i];
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        cp2 cp = new cp2();
        System.out.println(cp.reverse("abcd"));
    }
}
