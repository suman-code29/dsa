package trees.basic;

import trees.TreeNode;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(rh-lh) > 1) return false;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if (!left || !right) return false;

        return true;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
