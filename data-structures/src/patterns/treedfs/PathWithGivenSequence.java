package patterns.treedfs;

import trees.TreeNode;

import java.util.*;

public class PathWithGivenSequence {
    public boolean pathWithGivenSequence(TreeNode root, List<Integer> arr) {
        return dfs(root, arr, new ArrayList<>());
    }

    private boolean dfs(TreeNode root, List<Integer> arr, List<Integer> current) {
        if (root == null) return false;

        current.add(root.val);

        if (root.left == null && root.right == null && current.equals(arr)) {
            return true;
        }

        return dfs(root.left, arr, current) || dfs(root.right, arr, current);
    }
}
