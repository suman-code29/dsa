package trees.medium;

import trees.TreeNode;

public class ValidateBinarySearchTree {

    /*
    my code
     */
//    public boolean isValidBST(TreeNode root) {
//        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//
//    private boolean helper(TreeNode root, int left, int right) {
//        if (root == null) {
//            return true;
//        }
//
//        if (root.val > right && root.val < left) {
//            return false;
//        }
//
//        return (helper(root.left, left, root.val) && helper(root.right, root.val, right));
//    }

    /*
    chat gpt
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if ((min != null && root.val <= min) || max != null && root.val >= max) {
            return false;
        }

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public static void main(String[] args) {

    }
}
