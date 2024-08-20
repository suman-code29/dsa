package patterns.treedfs;

import trees.TreeNode;

import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        dfs(root, result, str);
        return result;
    }

    private void dfs(TreeNode root, List<String> result, StringBuilder str) {
        if (root == null) {
            return;
        }
        str.append(root.val + "->");

        if (root.left == null && root.right == null) {
            result.add(str.toString());
        } else {
            dfs(root.left, result, str);
            dfs(root.right, result, str);
        }

        str.delete(str.length()-2, str.length()-1);
    }
}
