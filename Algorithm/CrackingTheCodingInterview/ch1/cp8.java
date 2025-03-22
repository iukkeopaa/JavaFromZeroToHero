package CrackingTheCodingInterview.ch1;

public class cp8 {
    // 检查一个字符串是否是另一个字符串的子串
    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    // 检查 s2 是否是 s1 旋转而成的
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }
    public boolean isRotation2(String s1, String s2) {

        if (s1 == null && s2 == null) {
            return true;
        }

        if (s1 == null || s2 == null) {
            return false;
        }

        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isRotation(s1, s2));
    }
}
