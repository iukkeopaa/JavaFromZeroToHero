package MyCollections;

import java.util.Scanner;

//小红拿到了一个仅由大写字母和小写字母组成的字符串。她想知道，在不考虑大小写的情况下，有多少对相邻的字母相等？
//输入例子：
//"aABbbC"
//输出例子：
//3
public class StringDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i - 1))) {
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}