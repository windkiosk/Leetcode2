package leetcode.problems.algorithms;

import leetcode.problems.data.TreeNode;
import leetcode.problems.data.TreeNodePrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreePostOrder {

    public static void main(String[] strings) {
        TreePostOrder treepostOrder = new TreePostOrder();
        TreeNodePrinter.printNode(TreeNode.SAMPLE_0);
        System.out.println("recursive: " + treepostOrder.postOrderRecursively(TreeNode.SAMPLE_0));
        System.out.println("iterative: " + treepostOrder.postOrderIteratively(TreeNode.SAMPLE_0));
    }

    public List<Integer> postOrderRecursively(TreeNode treeNode) {
        if (treeNode == null) return null;
        List<Integer> ret = new LinkedList<>();
        List<Integer> left = postOrderRecursively(treeNode.left);
        List<Integer> right = postOrderRecursively(treeNode.right);
        if (left != null) {
            ret.addAll(left);
        }
        if (right != null) {
            ret.addAll(right);
        }
        ret.add(treeNode.val);
        return ret;
    }

    public List<Integer> postOrderIteratively(TreeNode root) {
        if (root == null) return null;

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        findRightMost(root, stack, ret);
        while (stack.size() > 0) {
            TreeNode pop = stack.pop();
            findRightMost(pop.left, stack, ret);
        }

        List<Integer> reverse = new ArrayList<>(ret.size());
        while (ret.size() > 0) {
            reverse.add(ret.remove(ret.size() - 1));
        }
        return reverse;
    }

    private void findRightMost(TreeNode root, Stack<TreeNode> stack, List<Integer> ret) {
        while (root != null) {
            stack.push(root);
            ret.add(root.val);
            root = root.right;
        }
    }
}
