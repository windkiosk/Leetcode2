package leetcode.problems.data;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    public static final TreeNode SAMPLE_0 = TreeNode.fromLevelString("1, 2, 3, 4, 5, #, 6, #, #, 7, 8, 9, #, 10");
    public static final TreeNode SAMPLE_1 = TreeNode.fromLevelString("2, 7, 5, 2, 6, 3, 6, 5, 8, 4, 5, 8, 4, 5, 8");

    public int val;
    public TreeNode left;
    public TreeNode right;

    public static void main(String[] strings) {
        TreeNodePrinter.printNode(SAMPLE_0);
        TreeNodePrinter.printNode(SAMPLE_1);
    }

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + ", L:" + (left == null ? "NULL" : left.val) + ", R:" + (right == null ? "NULL" : right.val);
    }

    /**
     * Creates {@link TreeNode} from level traversal string like "1, 2, 3, 4, 5, #, #, 7, 8, 9, #"
     *
     * @param levelStr level traversal string.
     * @return The generated {@link TreeNode}
     */
    public static TreeNode fromLevelString(String levelStr) {
        if (levelStr == null || levelStr.trim().length() == 0) return null;

        final String[] split = levelStr.split(",");
        if (split.length <= 0) return null;

        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int index = 1;
        while (queue.size() > 0  && index < split.length) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode treeNode = queue.poll();
                if (!split[index].trim().equals("#")) {
                    TreeNode tmp = new TreeNode(Integer.valueOf(split[index].trim()));
                    treeNode.left = tmp;
                    queue.add(tmp);
                }

                if (index + 1 < split.length &&!split[index + 1].trim().equals("#")) {
                    TreeNode tmp = new TreeNode(Integer.valueOf(split[index + 1].trim()));
                    treeNode.right = tmp;
                    queue.add(tmp);
                }

                index += 2;

                if (index >= split.length) {
                    break;
                }
            }
        }
        queue.clear();
        return root;
    }
}
