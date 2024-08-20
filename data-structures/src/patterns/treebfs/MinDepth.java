package patterns.treebfs;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int length = queue.size();
            level++;
            for(int i=0; i<length; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null) {
                    return level;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

        }
        return level;
    }
}
