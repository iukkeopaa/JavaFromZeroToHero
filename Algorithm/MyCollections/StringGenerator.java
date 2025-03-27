package MyCollections;

//小红给定了两个长度均为n的字符串 S 和 S?，仅包含小写字母。
//她想通过 S 和 S,生成一个长度为 n 的字符串 T，T 的生成规则如下:
//对于第i位，若 S:= S2:，则工为S:的大写形式，否则T=max(Si,S2:)。其中 max(,y)表示r和y字典
//序中较大的一个。
//现在小红想知道生成的字符串 T。
public class StringGenerator {
    public static String generateString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("两个字符串长度必须相同");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                result.append(Character.toUpperCase(c1));
            } else {
                result.append(c1 > c2? c1 : c2);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abce";
        String t = generateString(s1, s2);
        System.out.println(t);
    }
}