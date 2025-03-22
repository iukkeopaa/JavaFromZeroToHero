package TheLawofProgrammingAlgorithmsAndInterviewTips.Tree.Questions;

public class BSTPostorderCheck {
    public static boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private static boolean helper(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int i = start;
        while (postorder[i] < root) {
            i++;
        }
        int j = i;
        while (postorder[j] > root) {
            j++;
        }
        return j == end && helper(postorder, start, i - 1) && helper(postorder, i, end - 1);
    }

    public static void main(String[] args) {
        int[] postorder1 = {5, 7, 6, 9, 11, 10, 8};
        int[] postorder2 = {7, 4, 6, 5};
        System.out.println(verifyPostorder(postorder1)); 
        System.out.println(verifyPostorder(postorder2)); 
    }
}    