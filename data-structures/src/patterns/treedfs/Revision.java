package patterns.treedfs;

import com.sun.source.tree.Tree;
import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Revision {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        pathSumIIHelper(root, targetSum, current, result);
        return result;
    }

    private void pathSumIIHelper(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        current.add(root.val);

        if (sum == root.val && root.left == null && root.right == null) {
            result.add(new ArrayList<>(current));
        } else {
            pathSumIIHelper(root.left, sum-root.val, current, result);
            pathSumIIHelper(root.right, sum-root.val, current, result);
        }

        current.remove(current.size()-1);
    }

    public List<List<Integer>> binaryTreePaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        binaryTreePathsHelper(root, current, result);
        return result;
    }

    private void binaryTreePathsHelper(TreeNode root, List<Integer> current, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        current.add(root.val);

        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(current));
        } else {
            binaryTreePathsHelper(root.left, current, result);
            binaryTreePathsHelper(root.right, current, result);
        }

        current.remove(current.size()-1);
    }


    public int pathMaxSum(TreeNode root) {
        List<Integer> current = new ArrayList<>();
        pathMaxSumHelper(root, current);
        return pathMaxSumResult;
    }

    int pathMaxSumResult = 0;
    private void pathMaxSumHelper(TreeNode root, List<Integer> current) {
        if(root == null) {
            return;
        }

        current.add(root.val);
        int pathSum = 0;
        if (root.left == null && root.right == null) {
            for(int i : current) {
                pathSum += i;
            }
            pathMaxSumResult = Math.max(pathSum, pathMaxSumResult);
        } else {
            pathMaxSumHelper(root.left, current);
            pathMaxSumHelper(root.right, current);
        }
        current.remove(current.size()-1);
    }

    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, 0);
        return sumNumbersResult;
    }

    int sumNumbersResult = 0;
    private void sumNumbersHelper(TreeNode root, int current) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        System.out.println(current);
        current = 10 * current + root.val;
        if (root.left == null && root.right == null) {
            sumNumbersResult += current;
        } else {
            sumNumbersHelper(root.left, current);
            sumNumbersHelper(root.right, current);
        }
    }

    int diameterOfBinaryTreeResult = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameterOfBinaryTreeResult(root);
        return diameterOfBinaryTreeResult;
    }

    private int getDiameterOfBinaryTreeResult(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left  = getDiameterOfBinaryTreeResult(root.left);
        int right = getDiameterOfBinaryTreeResult(root.right);

        int dia = left + right;
        diameterOfBinaryTreeResult = Math.max(dia, diameterOfBinaryTreeResult);

        return Math.max(left, right)+1;
    }

    int maxPathSumResult;
    public int maxPathSum(TreeNode root) {
        maxPathSumResult = Integer.MIN_VALUE;
        getMaxPathSumResult(root);
        return maxPathSumResult;
    }

    private int getMaxPathSumResult(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getMaxPathSumResult(root.left);
        int right = getMaxPathSumResult(root.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);

        int currentMax = left+right+root.val;

        maxPathSumResult = Math.max(currentMax, maxPathSumResult);

        return Math.max(left, right) + root.val;

    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//
//        root.left.left = new TreeNode(11);
//
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right.right.right = new TreeNode(1);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        // Example targetSum to test
        int targetSum = 22;

        Revision revision = new Revision();
//        System.out.println(revision.hasPathSum(root, targetSum));
//        System.out.println(revision.pathSum(root, targetSum));
//        System.out.println(revision.binaryTreePaths(root));
//        System.out.println(revision.pathMaxSum(root));
//        System.out.println(revision.sumNumbers(root));
//        System.out.println(revision.diameterOfBinaryTree(root));
        System.out.println(revision.maxPathSum(root));
    }
}
