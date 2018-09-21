package leetcode.problems;

import leetcode.problems.data.TreeNode;

public class P104_DepOfBTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    //TODO https://discuss.leetcode.com/topic/27017/clean-java-iterative-solution
    public int maxDepthIterative(){return 0;}
}
