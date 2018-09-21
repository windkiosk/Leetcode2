package leetcode.problems;

import leetcode.problems.data.TreeNode;

public class P105_ConstructorTree {

    public static void main(String[] args) {
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};

        P105_ConstructorTree constructorTree = new P105_ConstructorTree();
        System.out.println(constructorTree.constructTree(pre, 0, pre.length, in, 0, in.length).toString());
    }

    TreeNode constructTree(int[] preOrder, int pre_s, int pre_l, int[] inOrder, int in_s, int in_l) {
        if (pre_l == 0) return null;

        int num = preOrder[pre_s];
        int index = -1;
        for (int i = in_s; i < in_s + in_l; i ++) {
            int curr = inOrder[i];
            if (curr == num) {
                index = i;
                break;
            }
        }

        int ll = index - in_s;
        int rl = in_l - ll - 1;

        TreeNode root = new TreeNode(num);
        root.left = constructTree(preOrder, pre_s + 1, ll, inOrder, in_s, ll);
        root.right = constructTree(preOrder, pre_s + ll + 1, rl, inOrder, index + 1, rl);
        return root;
    }
}
