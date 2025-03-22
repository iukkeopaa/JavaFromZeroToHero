package TheBeautyofProgramming.ch2;

import java.math.BigInteger;

public class DecimalToFraction {

    public static String decimalToFraction(String decimal) {
        if (!decimal.contains("(")) {
            return convertFiniteDecimal(decimal);
        } else {
            return convertRepeatingDecimal(decimal);
        }
    }

    private static String convertFiniteDecimal(String decimal) {
        int dotIndex = decimal.indexOf('.');
        if (dotIndex == -1) {
            return decimal + "/1";
        }
        int decimalPlaces = decimal.length() - dotIndex - 1;
        BigInteger numerator = new BigInteger(decimal.replace(".", ""));
        BigInteger denominator = BigInteger.TEN.pow(decimalPlaces);
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
        return numerator + "/" + denominator;
    }

    private static String convertRepeatingDecimal(String decimal) {
        int dotIndex = decimal.indexOf('.');
        int openParenthesisIndex = decimal.indexOf('(');
        int closeParenthesisIndex = decimal.indexOf(')');

        String nonRepeatingPart = decimal.substring(dotIndex + 1, openParenthesisIndex);
        String repeatingPart = decimal.substring(openParenthesisIndex + 1, closeParenthesisIndex);

        BigInteger nonRepeatingNumerator = new BigInteger(nonRepeatingPart.isEmpty() ? "0" : nonRepeatingPart);
        BigInteger repeatingNumerator = new BigInteger(repeatingPart);

        int nonRepeatingLength = nonRepeatingPart.length();
        int repeatingLength = repeatingPart.length();

        BigInteger denominator1 = BigInteger.TEN.pow(nonRepeatingLength + repeatingLength);
        BigInteger denominator2 = BigInteger.TEN.pow(nonRepeatingLength);

        BigInteger numerator = nonRepeatingNumerator.multiply(denominator1.subtract(denominator2))
                .add(repeatingNumerator);
        BigInteger denominator = denominator2.multiply(denominator1.divide(denominator2).subtract(BigInteger.ONE));

        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        System.out.println(decimalToFraction("0.3"));
        System.out.println(decimalToFraction("0.30"));
        System.out.println(decimalToFraction("0.3(000)"));
        System.out.println(decimalToFraction("0.3333(3333)"));
    }
}    