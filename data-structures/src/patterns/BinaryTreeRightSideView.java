package patterns;

import java.util.*;

public class BinaryTreeRightSideView {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> resultQueue = new LinkedList<>();
        resultQueue.add(root);

        while (!resultQueue.isEmpty()) {
            int size = resultQueue.size();

            for (int i=0; i<size;i++) {
                TreeNode current = resultQueue.poll();
                if (i == size-1) {
                    result.add(current.val);
                }
                if (current.left != null) {
                    resultQueue.add(current.left);
                }
                if (current.right != null) {
                    resultQueue.add(current.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        System.out.println(binaryTreeRightSideView.rightSideView(root));
    }
}
