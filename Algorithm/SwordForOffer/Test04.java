package SwordForOffer;

import java.util.Scanner;

public class Test04 {
    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
     *
     * @param string     要转换的字符数组
     * @param usedLength 已经字符数组中已经使用的长度
     * @return 转换后使用的字符长度，-1表示处理失败
     */
    public static int replaceBlank(char[] string, int usedLength) {
        // 判断输入是否合法
        if (string == null || string.length < usedLength) {
            return -1;
        }

        // 统计字符数组中的空白字符数
        int whiteCount = 0;
        for (int i = 0; i < usedLength; i++) {
            if (string[i] == ' ') {
                whiteCount++;
            }
        }

        // 计算转换后的字符长度是多少
        int targetLength = whiteCount * 2 + usedLength;
        int tmp = targetLength; // 保存长度结果用于返回
        if (targetLength > string.length) { // 如果转换后的长度大于数组的最大长度，直接返回失败
            return -1;
        }

        // 如果没有空白字符就不用处理
        if (whiteCount == 0) {
            return usedLength;
        }

        usedLength--; // 从后向前，第一个开始处理的字符
        targetLength--; // 处理后的字符放置的位置

        // 字符中有空白字符，一直处理到所有的空白字符处理完
        while (usedLength >= 0 && usedLength < targetLength) {
            // 如是当前字符是空白字符，进行"%20"替换
            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else { // 否则移动字符
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }

        return tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入字符串
        System.out.print("请输入要进行空格替换的字符串: ");
        String input = scanner.nextLine();

        // 考虑到每个空格会替换成 %20，长度最多变为原来的 3 倍，所以创建一个足够大的字符数组
        char[] string = new char[input.length() * 3];
        // 将输入的字符串复制到字符数组中
        for (int i = 0; i < input.length(); i++) {
            string[i] = input.charAt(i);
        }

        // 调用 replaceBlank 方法进行替换
        int length = replaceBlank(string, input.length());

        if (length == -1) {
            System.out.println("处理失败，请检查输入或数组容量。");
        } else {
            // 输出替换后的字符串
            System.out.println("替换后的字符串为: " + new String(string, 0, length));
        }

        scanner.close();
    }
}