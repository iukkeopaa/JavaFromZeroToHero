package MyCollections;

import java.util.Scanner;

//
public class StringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // 清除换行符

        String s = scanner.nextLine();
        String t = scanner.nextLine();

        for (int i = 0; i < n; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            int levelS = getLevel(cs);
            int levelT = getLevel(ct);

            if (levelS > 0 && levelT > 0) {
                if (levelS == levelT) {
                    System.out.print(getMiddleChar(cs, ct));
                } else {
                    System.out.print(getMiddleAscii(cs, ct));
                }
            } else {
                System.out.print("_");
            }
        }

        scanner.close();
    }

    // 获取字符的等级
    public static int getLevel(char c) {
        if (Character.isLowerCase(c)) {
            return 1;
        } else if (Character.isUpperCase(c)) {
            return 2;
        } else if (Character.isDigit(c)) {
            return 3;
        } else {
            return 0;
        }
    }

    // 获取两个字符的中位字符
    public static char getMiddleChar(char c1, char c2) {
        int mid = (int) Math.ceil((c1 + c2) / 2.0);
        return (char) mid;
    }

    // 获取两个字符的中位ASCII码
    public static int getMiddleAscii(char c1, char c2) {
        return (int) Math.ceil((c1 + c2) / 2.0);
    }
}