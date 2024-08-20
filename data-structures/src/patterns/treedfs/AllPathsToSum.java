package patterns.treedfs;

import trees.TreeNode;
import java.util.*;

public class AllPathsToSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(root, targetSum, result, current);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> current) {
        if (root == null) {
            return;
        }

        current.add(root.val);

        if (root.val == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(current));
        } else {
            dfs(root.left, targetSum-root.val, result, current);
            dfs(root.right, targetSum-root.val, result, current);
        }

        current.remove(current.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        AllPathsToSum allPathsToSum = new AllPathsToSum();
        allPathsToSum.pathSum(root, 22);
    }
}
