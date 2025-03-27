package MyCollections;

//小红定义一个字符串的权值为：字符串长度乘以字符串的字母种类数量。例如，"abacb"的价值为5*3=15。
//小红拿到了一个字符串，她准备将该字符串切分成

//k个子串（将这

//k个子串按顺序拼在一起即可得到原串）。小红希望切分后这

//k个子串的最大权值尽可能小。你能帮帮小红吗？你不需要给出一个方案，只需要返回最终这

//k个子串的最大权值即可。
//字符串仅包含小写字母，且长度不超过500000。
//k
//k为不超过字符串长度的正整数。
public class StringWeightSplit {
    public static int minMaxWeight(String s, int k) {
        int left = 1;
        int right = s.length() * 26;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(s, mid, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canSplit(String s, int maxWeight, int k) {
        int count = 1;
        int weight = 0;
        java.util.HashSet<Character> charSet = new java.util.HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charSet.add(c);
            weight++;
            if (weight * charSet.size() > maxWeight) {
                count++;
                weight = 1;
                charSet = new java.util.HashSet<>();
                charSet.add(c);
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        String s = "abacb";
        int k = 2;
        System.out.println(minMaxWeight(s, k)); 
    }
}