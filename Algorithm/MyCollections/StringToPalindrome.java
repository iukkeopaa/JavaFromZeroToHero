package MyCollections;

//小红有一个长度为
//n
//n 只包含小写字母的字符串，她想把这个字符串通过以下操作变成回文串：
//1. 选择字符串的第一个字母，将其插在字符串的末尾。例如，对于字符串
//a
//b
//c
//abc，得到
//b
//c
//a
//bca。
//2. 选择一个字符串的一个字符，将这个字符变成任意小写字母。
//每次只能进行上述两种操作中的一种，小红想知道最少需要进行多少次操作才能将字符串变成回文串。
public class StringToPalindrome {

    public static int minOperationsToPalindrome(String s) {
        int n = s.length();
        int minOperations = Integer.MAX_VALUE;

        // 尝试所有可能的循环移位
        for (int i = 0; i < n; i++) {
            // 进行循环移位
            String shifted = s.substring(i) + s.substring(0, i);
            // 计算当前移位后字符串变为回文串所需的替换操作次数
            int replaceCount = countReplacements(shifted);
            // 总操作次数 = 移位次数 + 替换次数
            int totalOperations = i + replaceCount;
            // 更新最小操作次数
            minOperations = Math.min(minOperations, totalOperations);
        }

        return minOperations;
    }

    // 计算将字符串变成回文串所需的替换操作次数
    private static int countReplacements(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "abc";
        int result = minOperationsToPalindrome(input);
        System.out.println("将字符串转换为回文串最少需要的操作次数: " + result);
    }
}    