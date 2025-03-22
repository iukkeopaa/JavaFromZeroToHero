package MyCollections.FindSubtreeNodes;

//说阿拉伯数字转成中文表达（比如 100050000->一亿零五万）
public class ArabicToChinese {
    private static final String[] CN_NUM = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] CN_UNIT = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

    public static String arabicToChinese(long num) {
        if (num == 0) {
            return CN_NUM[0];
        }

        StringBuilder result = new StringBuilder();
        boolean zeroFlag = false;
        int unitIndex = 0;

        while (num > 0) {
            int digit = (int) (num % 10);
            if (digit == 0) {
                if (!zeroFlag) {
                    result.insert(0, CN_NUM[0]);
                    zeroFlag = true;
                }
            } else {
                if (zeroFlag) {
                    result.insert(0, CN_NUM[0]);
                    zeroFlag = false;
                }
                result.insert(0, CN_UNIT[unitIndex]);
                result.insert(0, CN_NUM[digit]);
            }
            num /= 10;
            unitIndex++;
        }

        // 去除多余的零
        while (result.indexOf("零") == result.length() - 1) {
            result.deleteCharAt(result.length() - 1);
        }

        // 处理一十的情况
        if (result.length() >= 2 && result.substring(0, 2).equals("一十")) {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        long num = 100050000;
        System.out.println(arabicToChinese(num));
    }
}    