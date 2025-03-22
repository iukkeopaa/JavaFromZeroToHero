package CrackingTheCodingInterview.ch1;

public class cp1 {
    public boolean isUniqueChars(String str) {
        // 如果字符串为空认为不含重复的字符
        if (str == null) {
            return true;
        }

        // 长度大于256就一定有重复的
        if (str.length() > 256) {
            return false;
        }

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            // 求字母的序号，从0开始/
            //把当前字符转化为从 0 开始的序号。例如，'a' 对应的序号是 0，'b' 对应的序号是 1，依此类推。
            int val = str.charAt(i) - 'a';
            //checker 是一个整数，用来记录哪些字母已经出现过。1 << val 会生成一个只有第 val 位为 1 的整数。通过 checker & (1 << val) 进行按位与运算，要是结果大于 0，就表明第 val 个字母已经出现过，此时返回 false。
            // 如果第val个字母已经出现过返回false
            if ((checker & (1 << val)) > 0) {
                return false;
            } else {
                // 标记第val个数字已经出现了
                checker |= (1 << val);
            }
        }

        return true;
    }

    /**
     * 第一种解法是构建一个布尔值的数组，索引值i对应的标记指示该字符串是否含有字母表第i
     * 个字符。若这个字符第二次出现，则立即返回false 。
     * 使用位向量（ bit vector ），可以将空间占用减少为原先的1/8 。
     *
     * @param str
     * @return
     */
    public boolean isUniqueChars2(String str) {

        // 如果字符串为空认为不含重复的字符
        if (str == null) {
            return true;
        }

        // 长度大于256就一定有重复的
        if (str.length() > 256) {
            return false;
        }

        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            // 如果之前已经出现过该字符，就返回false
            if (charSet[val]) {
                return false;
            } else {
                // 标记字符已经出现过
                charSet[val] = true;
            }
        }

        // 没有出现过重复的字符
        return true;
    }




    public static void main(String[] args) {
        StringBuilder longString = new StringBuilder();
        for (int i = 0; i < 257; i++) {
            longString.append('a');
        }
        cp1 cp = new cp1();
        System.out.println(cp.isUniqueChars("abc"));
        System.out.println(cp.isUniqueChars2(""));
        System.out.println(cp.isUniqueChars2("aab"));
        System.out.println(cp.isUniqueChars2(String.valueOf(longString)));
    }
}
