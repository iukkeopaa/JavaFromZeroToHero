package MyCollections.FindSubtreeNodes.NumberOutput;

public class NumberOutput {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            String output;
            if (i % 7 == 0 || String.valueOf(i).contains("7")) {
                output = "*";
            } else {
                output = String.valueOf(i);
            }
            if (count > 0) {
                System.out.print(",");
            }
            System.out.print(output);
            count++;
            if (count % 5 == 0) {
                System.out.println();
                count = 0;
            }
        }
    }
}    