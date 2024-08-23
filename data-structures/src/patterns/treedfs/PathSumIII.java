package patterns.treedfs;

import trees.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> current = new ArrayList<>();
        return dfs(root, targetSum, current);
    }

    private int dfs(TreeNode root, int targetSum, List<Integer> current) {
        if (root == null) {
            return 0;
        }

        current.add(root.val);
        int pathCount = 0;
        int pathSum = 0;

        ListIterator<Integer> pathIterator = current.listIterator(current.size());
        while(pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            if (pathSum == targetSum) {
                pathCount++;
            }
        }

        pathCount += dfs(root.right, targetSum, current);
        pathCount += dfs(root.left, targetSum, current);

        current.remove(current.size()-1);
        return pathCount;
    }

//    public static void main(String[] args) {
//        // Construct the binary tree as per the input: [5,4,8,11,null,13,4,7,2,null,null,5,1]
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);
//
//        // Define targetSum
//        int targetSum = 22;
//
//        // Create an instance of the PathSumCounter and call the pathSum method
//        PathSumIII pathSumCounter = new PathSumIII();
//        int result = pathSumCounter.pathSum(root, targetSum);
//
//        // Print the result
//        System.out.println("Number of paths that sum to " + targetSum + ": " + result);
//    }

    public static void main(String[] args) {
        // Construct the binary tree as per the input: [10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        // Define targetSum
        int targetSum = 8;

        // Create an instance of the PathSumCounter and call the pathSum method
        PathSumIII pathSumCounter = new PathSumIII();
        int result = pathSumCounter.pathSum(root, targetSum);

        // Print the result
        System.out.println("Number of paths that sum to " + targetSum + ": " + result);
    }
}
