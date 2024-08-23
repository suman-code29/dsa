package patterns.treedfs;

import trees.TreeNode;

public class TreeDiameter {
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int dia = left+right;

        result = Math.max(dia, result);

        return Math.max(left, right)+1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeDiameter treeDiameter = new TreeDiameter();
        System.out.println(treeDiameter.diameterOfBinaryTree(root));
    }
}