package patterns.treedfs;

import trees.TreeNode;

import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> current =  new ArrayList<>();
        List<List<Integer>> result =  new ArrayList<>();
        List<String> data = new ArrayList<>();
        dfs(root, result, current);
        for(List<Integer> curr : result) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i<curr.size(); i++) {
                if(i != curr.size()-1) {
                    stringBuilder.append(curr.get(i)).append("->");
                } else {
                    stringBuilder.append(curr.get(i));
                }
            }
            data.add(stringBuilder.toString());
        }

        return data;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, List<Integer> current) {
        if (root == null) {
            return;
        }

        current.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(current));
        } else {
            dfs(root.left, result, current);
            dfs(root.right, result, current);
        }

        current.remove(current.size()-1);
    }
}
