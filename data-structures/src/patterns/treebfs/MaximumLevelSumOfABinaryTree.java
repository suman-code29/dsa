package patterns.treebfs;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = 0;
        int level = 0;
        int result = 0;
        while(!queue.isEmpty()) {
            int length = queue.size();
            int sum = 0;
            for(int i=0; i<length; i++) {
                level++;
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                result = level;
            }
        }
        return result;
    }
}
