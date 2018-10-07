package leetcode.problems;

import leetcode.problems.data.TreeNode;
import leetcode.problems.data.TreeNodePrinter;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Google.
 *
 * Invert a binary tree.
 *
 * For example, given the following tree:
 *
 *     a
 *    / \
 *   b   c
 *  / \  /
 * d   e f
 * should become:
 *
 *   a
 *  / \
 *  c  b
 *  \  / \
 *   f e  d
 */
public class MirrorTreeCopy {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.fromLevelString("1, 2, 3, 4, 5, #, #, 7, 8, 9, #");
        TreeNodePrinter.printNode(treeNode);
        TreeNodePrinter.printNode(mirrorCopy(treeNode));
    }

    public static TreeNode mirrorCopy(TreeNode origin) {
        if (origin == null) return null;

        TreeNode node = new TreeNode(origin.val);
        node.left = mirrorCopy(origin.right);
        node.right = mirrorCopy(origin.left);
        return node;
    }
}
