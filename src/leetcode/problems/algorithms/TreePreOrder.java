package leetcode.problems.algorithms;

import leetcode.problems.data.TreeNode;
import leetcode.problems.data.TreeNodePrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreePreOrder {

    public static void main(String[] strings) {
        TreePreOrder treePreOrder = new TreePreOrder();
        TreeNodePrinter.printNode(TreeNode.SAMPLE_0);
        System.out.println("recursive : " + treePreOrder.preOrderRecursively(TreeNode.SAMPLE_0));
        System.out.println("iterative : " + treePreOrder.preOrderIteratively(TreeNode.SAMPLE_0));
        System.out.println("iterative2: " + treePreOrder.preOrderIteratively2(TreeNode.SAMPLE_0));
    }

    public List<Integer> preOrderRecursively(TreeNode treeNode) {
        if (treeNode == null) return null;
        List<Integer> ret = new LinkedList<>();
        ret.add(treeNode.val);
        List<Integer> left = preOrderRecursively(treeNode.left);
        List<Integer> right = preOrderRecursively(treeNode.right);
        if (left != null) {
            ret.addAll(left);
        }
        if (right != null) {
            ret.addAll(right);
        }
        return ret;
    }

    public List<Integer> preOrderIteratively2(TreeNode root) {
        if (root == null) return null;

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode pop = stack.pop();
            ret.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return ret;
    }

    public List<Integer> preOrderIteratively(TreeNode root) {
        if (root == null) return null;

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        findLeftMost(root, stack, ret);
        while (stack.size() > 0) {
            TreeNode pop = stack.pop();
            findLeftMost(pop.right, stack, ret);
        }
        return ret;
    }

    private void findLeftMost(TreeNode root, Stack<TreeNode> stack, List<Integer> ret) {
        while (root != null) {
            stack.push(root);
            ret.add(root.val);
            root = root.left;
        }
    }
}