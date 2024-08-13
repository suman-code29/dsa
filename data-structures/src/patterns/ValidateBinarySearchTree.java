package patterns;

public class ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.val > root.left.val) {
            return true;
        }
        if (root.right != null && root.val < root.right.val) {
            return true;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

    }
}
