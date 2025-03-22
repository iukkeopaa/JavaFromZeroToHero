package TheLawofProgrammingAlgorithmsAndInterviewTips.Tree.Questions;



public class BinaryTreeStoneDistribution {
    private int steps = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return steps;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        steps += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }

    public static void main(String[] args) {
        // 构建一个示例二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        BinaryTreeStoneDistribution solution = new BinaryTreeStoneDistribution();
        int result = solution.distributeCoins(root);
        System.out.println("最少搬运步骤: " + result);
    }
}    