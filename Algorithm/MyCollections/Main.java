package MyCollections;

import java.util.Scanner;

//题目内容
//小美有一个加密的字符串s，你无意之间得到了他的加密方式，尝试解开它吧!
//初始时，解密字符串t为空,除此之外,还有一个记录位移的整数p为0。依次对每一个i = 1,2,…,s
//进行以下操作(其中鼎代表字符串s的长度)
//·如果s的第i个字符为数字，则需要对p修改，具体地:
//若p =0，则将p置为(即p→> ?);
//若p ≠0，则将p中的数字全部向高位移动一位，随后将空出来的个位填上(即p → 10p+?)
//如果s的第i个字符不为数字，则需要先将字符串左移p位(即t,t..t,tp+1..:→ tp+1...t tt...t,),随后将p重新
//置为0，再对t修改，具体地:
//若字符为R，则反转字符串t
//若字符不为R，则直接将这个字符添加到字符串t的结尾;
//请你直接输出解密完成后的字符串t。
//输入描述
//每个测试文件均包含多组测试数据。第一行输入一个整数T(1 < T < 10)代表数据组数,每组测试数据描述如下:
//在一行上输入一个长度为|s|(1 < |8| < 103),且由大小写字母和数字混合构成的字符串s代表小美的加密串,
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < T; i++) {
            String s = scanner.nextLine();
            System.out.println(decrypt(s));
        }
        scanner.close();
    }

    public static String decrypt(String s) {
        StringBuilder t = new StringBuilder();
        int p = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (p == 0) {
                    p = digit;
                } else {
                    p = 10 * p + digit;
                }
            } else {
                if (p > 0) {
                    int len = t.length();
                    p = p % len;
                    String left = t.substring(0, p);
                    String right = t.substring(p);
                    t = new StringBuilder(right + left);
                }
                p = 0;
                if (c == 'R') {
                    t.reverse();
                } else {
                    t.append(c);
                }
            }
        }
        return t.toString();
    }
}    