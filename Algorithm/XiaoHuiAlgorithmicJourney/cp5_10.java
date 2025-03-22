package XiaoHuiAlgorithmicJourney;

import java.math.BigInteger;

public class cp5_10 {
    public static void main(String[] args) {
        // 定义两个很大的整数
        BigInteger num1 = new BigInteger("12345678901234567890");
        BigInteger num2 = new BigInteger("98765432109876543210");

        // 计算两个大整数的和
        BigInteger sum = num1.add(num2);

        // 输出结果
        System.out.println("两个大整数的和是: " + sum);
    }

    public class BigIntegerAddition {
        public static void main(String[] args) {
            String num1Str = "12345678901234567890";
            String num2Str = "98765432109876543210";

            // 将字符串转换为字符数组
            char[] num1Chars = num1Str.toCharArray();
            char[] num2Chars = num2Str.toCharArray();

            // 找到较长的数字长度
            int maxLength = Math.max(num1Chars.length, num2Chars.length);
            int[] result = new int[maxLength + 1];

            int carry = 0;
            int i = num1Chars.length - 1;
            int j = num2Chars.length - 1;
            int k = result.length - 1;

            // 逐位相加
            while (i >= 0 || j >= 0) {
                int digit1 = (i >= 0)? num1Chars[i] - '0' : 0;
                int digit2 = (j >= 0)? num2Chars[j] - '0' : 0;

                int sum = digit1 + digit2 + carry;
                result[k] = sum % 10;
                carry = sum / 10;

                i--;
                j--;
                k--;
            }

            // 处理最后可能的进位
            result[k] = carry;

            // 输出结果
            StringBuilder output = new StringBuilder();
            boolean leadingZero = true;
            for (int digit : result) {
                if (leadingZero && digit == 0) {
                    continue;
                }
                leadingZero = false;
                output.append(digit);
            }

            if (output.length() == 0) {
                System.out.println("0");
            } else {
                System.out.println("两个大整数的和是: " + output.toString());
            }
        }
    }
}
