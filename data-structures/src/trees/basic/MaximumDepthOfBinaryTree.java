package trees.basic;

import com.sun.source.tree.Tree;
import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthUsingBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);  // Initialize the deque with the root node

        while (!deque.isEmpty()) {
            int size = deque.size();  // Number of nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();  // Retrieve and remove the head of the deque
                if (node.left != null) {
                    deque.add(node.left);  // Add left child to the deque
                }
                if (node.right != null) {
                    deque.add(node.right);  // Add right child to the deque
                }
            }
            level++;  // Increment the level after processing all nodes at the current level
        }

        return level;
    }
}
