package MyCollections.FindSubtreeNodes;

//求两个 String 类型的整形加法 String num1 = "123";String num1 = "456";相加然后反转
public class StringAdditionAndReverse {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String result = addStrings(num1, num2);
        String reversedResult = reverseString(result);
        System.out.println(reversedResult);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}    