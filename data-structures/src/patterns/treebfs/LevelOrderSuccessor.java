package patterns.treebfs;

import trees.TreeNode;

import java.util.*;

public class LevelOrderSuccessor {
    public int levelOrder(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> currentArray = new ArrayList<>();
            for(int i=0; i<length; i++) {
                TreeNode current = queue.poll();
                if (current.val == k) {
                    return Objects.requireNonNull(queue.poll()).val;
                }
                currentArray.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return -1;
    }
}
