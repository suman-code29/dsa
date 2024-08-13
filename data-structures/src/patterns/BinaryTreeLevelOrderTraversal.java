package patterns;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> resultQueue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            resultQueue.add(root);
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(temp);
        }


        while (!resultQueue.isEmpty()) {
            TreeNode current = resultQueue.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            if (current.left != null) {
                temp.add(current.left.val);
                resultQueue.add(current.left);
            }
            if (current.right != null) {
                temp.add(current.right.val);
                resultQueue.add(current.right);
            }
            if (!temp.isEmpty()) {
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder(root));
    }
}
