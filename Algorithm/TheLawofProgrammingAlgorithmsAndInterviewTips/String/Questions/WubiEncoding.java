package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

public class WubiEncoding {

    // 函数用于根据编码获取对应的数组下标
    public static int getIndexFromEncoding(String encoding) {
        int index = 0;
        int length = encoding.length();
        // 先计算长度小于当前编码长度的所有编码的数量
        for (int i = 1; i < length; i++) {
            index += Math.pow(25, i);
        }
        // 再计算当前长度编码中，当前编码之前的编码数量
        for (int i = 0; i < length; i++) {
            int charIndex = encoding.charAt(i) - 'a';
            index += charIndex * Math.pow(25, length - i - 1);
            if (i < length - 1) {
                index++;
            }
        }
        return index;
    }

    // 函数用于根据数组下标获取对应的编码
    public static String getEncodingFromIndex(int index) {
        int length = 1;
        int total = 0;
        // 确定编码的长度
        while (total + Math.pow(25, length) <= index) {
            total += Math.pow(25, length);
            length++;
        }
        index -= total;
        StringBuilder encoding = new StringBuilder();
        // 根据下标计算编码
        for (int i = length - 1; i >= 0; i--) {
            int charIndex = index / (int) Math.pow(25, i);
            encoding.append((char) ('a' + charIndex));
            index %= Math.pow(25, i);
        }
        return encoding.toString();
    }

    public static void main(String[] args) {
        String encoding = "baca";
        int index = getIndexFromEncoding(encoding);
        System.out.println("编码 " + encoding + " 对应的数组下标是: " + index);

        index = 12345;
        encoding = getEncodingFromIndex(index);
        System.out.println("数组下标 " + index + " 对应的编码是: " + encoding);
    }
}    