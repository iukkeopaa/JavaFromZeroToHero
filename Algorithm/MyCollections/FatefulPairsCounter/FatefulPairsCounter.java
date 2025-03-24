package MyCollections.FindSubtreeNodes.FatefulPairsCounter;

public class FatefulPairsCounter {
    public static int countFatefulPairs(String s, int g) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i % 2 == j % 2 && Math.abs(s.charAt(i) - s.charAt(j)) <= g) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcde";
        int g = 1;
        int result = countFatefulPairs(s, g);
        System.out.println("缘分对的个数是: " + result);
    }
}    