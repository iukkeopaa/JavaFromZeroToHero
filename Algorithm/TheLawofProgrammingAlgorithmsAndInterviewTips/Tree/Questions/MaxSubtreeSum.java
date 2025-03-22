package TheLawofProgrammingAlgorithmsAndInterviewTips.Tree.Questions;



class Result {
    int sum;
    int maxSum;
    TreeNode maxSubtree;
    Result(int sum, int maxSum, TreeNode maxSubtree) {
        this.sum = sum;
        this.maxSum = maxSum;
        this.maxSubtree = maxSubtree;
    }
}

public class MaxSubtreeSum {

    public TreeNode findMaxSubtree(TreeNode root) {
        return helper(root).maxSubtree;
    }

    private Result helper(TreeNode node) {
        if (node == null) {
            return new Result(0, Integer.MIN_VALUE, null);
        }
        Result left = helper(node.left);
        Result right = helper(node.right);

        int sum = node.val + left.sum + right.sum;
        int maxSum = Math.max(sum, Math.max(left.maxSum, right.maxSum));
        TreeNode maxSubtree;
        if (maxSum == sum) {
            maxSubtree = node;
        } else if (maxSum == left.maxSum) {
            maxSubtree = left.maxSubtree;
        } else {
            maxSubtree = right.maxSubtree;
        }
        return new Result(sum, maxSum, maxSubtree);
    }

    // (1) 找出只含正整数的最大子树
    public TreeNode findMaxPositiveSubtree(TreeNode root) {
        return helperPositive(root, true).maxSubtree;
    }

    private Result helperPositive(TreeNode node, boolean onlyPositive) {
        if (node == null) {
            return new Result(0, Integer.MIN_VALUE, null);
        }
        Result left = helperPositive(node.left, onlyPositive);
        Result right = helperPositive(node.right, onlyPositive);

        int sum = node.val;
        if (onlyPositive && node.val <= 0) {
            sum = 0;
        } else {
            if (left.sum > 0 ||!onlyPositive) {
                sum += left.sum;
            }
            if (right.sum > 0 ||!onlyPositive) {
                sum += right.sum;
            }
        }
        int maxSum = Math.max(sum, Math.max(left.maxSum, right.maxSum));
        TreeNode maxSubtree;
        if (maxSum == sum) {
            maxSubtree = node;
        } else if (maxSum == left.maxSum) {
            maxSubtree = left.maxSubtree;
        } else {
            maxSubtree = right.maxSubtree;
        }
        return new Result(sum, maxSum, maxSubtree);
    }

    // (2) 子树定义为它和它的部分后代
    // 可以通过遍历所有可能的子树来解决
    public TreeNode findMaxPartialSubtree(TreeNode root) {
        return helperPartial(root).maxSubtree;
    }

    private Result helperPartial(TreeNode node) {
        if (node == null) {
            return new Result(0, Integer.MIN_VALUE, null);
        }
        Result left = helperPartial(node.left);
        Result right = helperPartial(node.right);

        int sum = node.val;
        int leftSum = Math.max(0, left.sum);
        int rightSum = Math.max(0, right.sum);
        sum += leftSum + rightSum;

        int maxSum = Math.max(sum, Math.max(left.maxSum, right.maxSum));
        TreeNode maxSubtree;
        if (maxSum == sum) {
            maxSubtree = node;
        } else if (maxSum == left.maxSum) {
            maxSubtree = left.maxSubtree;
        } else {
            maxSubtree = right.maxSubtree;
        }
        return new Result(sum, maxSum, maxSubtree);
    }

    // (3) 对于第 2 个问题，加上正整数的限制
    public TreeNode findMaxPositivePartialSubtree(TreeNode root) {
        return helperPositivePartial(root, true).maxSubtree;
    }

    private Result helperPositivePartial(TreeNode node, boolean onlyPositive) {
        if (node == null) {
            return new Result(0, Integer.MIN_VALUE, null);
        }
        Result left = helperPositivePartial(node.left, onlyPositive);
        Result right = helperPositivePartial(node.right, onlyPositive);

        int sum = node.val;
        if (onlyPositive && node.val <= 0) {
            sum = 0;
        } else {
            int leftSum = Math.max(0, left.sum);
            int rightSum = Math.max(0, right.sum);
            if (onlyPositive) {
                if (leftSum > 0) {
                    sum += leftSum;
                }
                if (rightSum > 0) {
                    sum += rightSum;
                }
            } else {
                sum += leftSum + rightSum;
            }
        }
        int maxSum = Math.max(sum, Math.max(left.maxSum, right.maxSum));
        TreeNode maxSubtree;
        if (maxSum == sum) {
            maxSubtree = node;
        } else if (maxSum == left.maxSum) {
            maxSubtree = left.maxSubtree;
        } else {
            maxSubtree = right.maxSubtree;
        }
        return new Result(sum, maxSum, maxSubtree);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        MaxSubtreeSum solution = new MaxSubtreeSum();
        TreeNode maxSubtree = solution.findMaxSubtree(root);
        System.out.println("Max subtree root value: " + maxSubtree.val);

        TreeNode maxPositiveSubtree = solution.findMaxPositiveSubtree(root);
        System.out.println("Max positive subtree root value: " + maxPositiveSubtree.val);

        TreeNode maxPartialSubtree = solution.findMaxPartialSubtree(root);
        System.out.println("Max partial subtree root value: " + maxPartialSubtree.val);

        TreeNode maxPositivePartialSubtree = solution.findMaxPositivePartialSubtree(root);
        System.out.println("Max positive partial subtree root value: " + maxPositivePartialSubtree.val);
    }
}    