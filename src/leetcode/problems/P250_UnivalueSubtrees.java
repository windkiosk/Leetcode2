package leetcode.problems;

import leetcode.problems.data.TreeNode;

public class P250_UnivalueSubtrees {

    public static void main(String[] args) {
        P250_UnivalueSubtrees univalueSubtrees_250 = new P250_UnivalueSubtrees();
        // System.out.println(univalueSubtrees_250.countUnivalueTrees(TreeNode.fromLevelString("5,1,5,5,5,#,5")));
        // System.out.println(univalueSubtrees_250.countUnivalueTrees(TreeNode.fromLevelString("5,5,5,5,5,#,5")));
         System.out.println(univalueSubtrees_250.countUnivalueTrees(TreeNode.fromLevelString("5,1,5,5,5,#,5")));
    }

    int countUnivalueTrees(TreeNode root) {
        int[] ret = new int[1];
        postOrder(root, ret);
        return ret[0];
    }

    int postOrder(TreeNode node, int[] ret) {
        if (node == null) return Integer.MIN_VALUE;

        int left = postOrder(node.left, ret);
        int right = postOrder(node.right, ret);

        if ((left == Integer.MIN_VALUE || left == node.val)
                        && (right == Integer.MIN_VALUE || right == node.val)) {
            ret[0] ++;
            return node.val;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
