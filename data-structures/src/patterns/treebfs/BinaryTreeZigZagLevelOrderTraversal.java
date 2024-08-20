package patterns.treebfs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> currentArray = new LinkedList<>();
            for(int i=0; i<length; i++) {
                TreeNode current = queue.poll();
                if (leftToRight) {
                    currentArray.add(current.val);
                } else {
                    currentArray.add(0, current.val);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(currentArray);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
