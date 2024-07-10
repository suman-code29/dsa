package trees.medium;

import com.sun.source.tree.Tree;
import trees.TreeNode;

import java.util.*;

public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        if (root == null) {
            return 1;
        }

        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res.get(k-1);
    }

    public void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root != null) {
            inorderTraversal(root.left, arr);
            arr.add(root.val);
            inorderTraversal(root.right, arr);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();
        System.out.println(kthSmallestElementInABST.kthSmallest(root, 1));

    }
}
