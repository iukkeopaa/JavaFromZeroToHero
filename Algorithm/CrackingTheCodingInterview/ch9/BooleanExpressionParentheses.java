package CrackingTheCodingInterview.ch9;

import java.util.HashMap;
import java.util.Map;

public class BooleanExpressionParentheses {

    // 用于存储已经计算过的子问题结果，避免重复计算
    private static Map<String, Integer> memo = new HashMap<>();

    public static int countEval(String s, boolean result) {
        return countEvalHelper(s, result);
    }

    private static int countEvalHelper(String s, boolean result) {
        // 如果字符串为空，直接返回 0
        if (s.length() == 0) {
            return 0;
        }
        // 如果字符串只有一个字符，判断该字符是否符合结果
        if (s.length() == 1) {
            return stringToBool(s) == result ? 1 : 0;
        }
        // 生成当前子问题的唯一键
        String key = result + s;
        // 如果该子问题已经计算过，直接从缓存中获取结果
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ways = 0;
        // 遍历表达式中的每个运算符
        for (int i = 1; i < s.length(); i += 2) {
            char operator = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1);

            // 计算左右子表达式分别为 true 和 false 的方法数
            int leftTrue = countEvalHelper(left, true);
            int leftFalse = countEvalHelper(left, false);
            int rightTrue = countEvalHelper(right, true);
            int rightFalse = countEvalHelper(right, false);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
            int totalTrue = 0;

            // 根据不同的运算符计算总的 true 结果数
            switch (operator) {
                case '&':
                    totalTrue = leftTrue * rightTrue;
                    break;
                case '|':
                    totalTrue = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                    break;
                case '^':
                    totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
                    break;
            }

            // 根据期望结果更新方法数
            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }
        // 将当前子问题的结果存入缓存
        memo.put(key, ways);
        return ways;
    }

    // 将字符串转换为布尔值
    private static boolean stringToBool(String s) {
        return s.equals("1");
    }

    public static void main(String[] args) {
        String expression = "1^0|0|1";
        boolean result = false;
        System.out.println("使表达式 " + expression + " 得出 " + result + " 的括号放法有 " + countEval(expression, result) + " 种。");
    }
}    