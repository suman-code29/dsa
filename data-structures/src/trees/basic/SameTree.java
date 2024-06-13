package trees.basic;

import trees.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) {
            return true;
        } else if (p==null && q!=null) {
            return false;
        } else if (p != null && q==null){
            return false;
        }

        if (p.val != q.val) {
            return false;
        } else
            return (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));
    }


    public static void main(String[] args) {
        int[] p = new int[]{1,2,3};
        int[] q = new int[]{1,2,3};

        TreeNode treeNodeP = new TreeNode(p[0], new TreeNode(p[1]), new TreeNode(p[2]));
        TreeNode treeNodeQ = new TreeNode(q[0], new TreeNode(q[1]), new TreeNode(q[2]));

        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(treeNodeP, treeNodeQ));
    }
}
