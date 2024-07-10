package trees.medium;

import trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null || inorder==null){
            return null;
        }

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return solve(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inorderMap);
    }

    private TreeNode solve(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> inorderMap) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = inorderMap.get(preorder[preStart]);
        int numLeft = idx - inStart;

        root.left = solve(preorder, preStart+1, preStart+numLeft, inorder, inStart, idx+1, inorderMap);
        root.right = solve(preorder, preStart+numLeft+1, preEnd, inorder, idx+1, inEnd, inorderMap);

        return root;
    }


}
