package MyCollections.FindSubtreeNodes.ArrayConstruction;

public class ArrayConstruction {
    public static int[] multiply(int[] A) {
        int length = A.length;
        if (length == 0) {
            return new int[0];
        }
        int[] B = new int[length];
        // 计算下三角部分
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        // 计算上三角部分
        int temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = multiply(A);
        for (int num : B) {
            System.out.print(num + " ");
        }
    }
}    