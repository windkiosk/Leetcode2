package leetcode.problems.algorithms;

import leetcode.problems.data.TreeNode;
import leetcode.problems.data.TreeNodePrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeInOrder {

    public static void main(String[] strings) {
        TreeInOrder treeInOrder = new TreeInOrder();
        TreeNodePrinter.printNode(TreeNode.SAMPLE_0);
        System.out.println("recursive: " + treeInOrder.inOrderRecursively(TreeNode.SAMPLE_0));
        System.out.println("iterative: " + treeInOrder.inOrderIteratively(TreeNode.SAMPLE_0));
    }

    public List<Integer> inOrderRecursively(TreeNode treeNode) {
        if (treeNode == null) return null;
        List<Integer> left = inOrderRecursively(treeNode.left);
        List<Integer> right = inOrderRecursively(treeNode.right);

        List<Integer> ret = new LinkedList<>();
        if (left != null) {
            ret.addAll(left);
        }
        ret.add(treeNode.val);
        if (right != null) {
            ret.addAll(right);
        }
        return ret;
    }

    public List<Integer> inOrderIteratively(TreeNode root) {
        if (root == null) return null;

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        findLeftMost(root, stack);
        while (stack.size() > 0) {
            final TreeNode pop = stack.pop();
            ret.add(pop.val);
            if (pop.right != null) {
                findLeftMost(pop.right, stack);
            }
        }
        return ret;
    }

    private void findLeftMost(TreeNode root, Stack<TreeNode> stack) {
        TreeNode node = root;
        while (node.left != null) {
            stack.push(node);
            node = node.left;
        }
        stack.push(node);
    }
}
