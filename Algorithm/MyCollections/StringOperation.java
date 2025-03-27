package MyCollections;

import java.util.Scanner;

//题目内容
//米小游正有一个长度为n 的字符串s，他将依次对每一个i= 1,2,…,n 进行以下操作:
//如果s的第i个字符为大写字母，则将其替换为字母表中下一个字母(特别的，2 替换为 A);
//如果s的第i个字符为小写字母，则将其替换为字母表中上一个字母(特别的，a 替换为 z)。
//如果s的第i个字符为数字，则将是替换为其加1(特别的，9 替换为 0);
//如果s的第i个字符为其他内容，则输出一条下划线"”。
//输入描述
//第一行输入一个整数 n(1 ≤ n≤3 x 10')代表字符串的长度。
//第二行输入一个长度为”，且由数字、大小写字母、空格及!?.+-*/这七个常见半角符号构成的字符串s代表待
//操作的字符串。特别的，保证字符串的首尾不为空格。
//输出描述
//在一行上输出一个字符串，代表操作过后的字符串。
public class StringOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                if (c == 'Z') {
                    result.append('A');
                } else {
                    result.append((char) (c + 1));
                }
            } else if (Character.isLowerCase(c)) {
                if (c == 'a') {
                    result.append('z');
                } else {
                    result.append((char) (c - 1));
                }
            } else if (Character.isDigit(c)) {
                if (c == '9') {
                    result.append('0');
                } else {
                    result.append((char) (c + 1));
                }
            } else {
                result.append("_");
            }
        }
        System.out.println(result.toString());
        scanner.close();
    }
}    